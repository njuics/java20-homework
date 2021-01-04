package nju.zjl.cvs.game;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.function.IntUnaryOperator;

import com.google.common.collect.ComparisonChain;

public class Algorithms {
    public static int[] findPath(int[] map, int columns, int src, int dest){
        PriorityQueue<Node> openList = new PriorityQueue<>();  
        int len = map.length;
        boolean[] visited = new boolean[len];
        IntUnaryOperator countingH = x -> Math.abs(x / columns - dest / columns) + Math.abs(x % columns - dest % columns);

        openList.add(new Node(src, 0, countingH.applyAsInt(src), new Node()));
        while(!openList.isEmpty()){
            Node n = openList.poll();
            if(visited[n.p]){
                continue;
            }
            visited[n.p] = true;
            if(n.p == dest){
                return resolvePath(n);
            }
            updateFringe(map, columns, n, countingH, openList, visited);
        }
        return new int[0];
    }

    public static int[] findAtkPath(int[] map, int columns, int src, int dest, int atkRange){
        PriorityQueue<Node> openList = new PriorityQueue<>();  
        int len = map.length;
        boolean[] visited = new boolean[len];
        IntUnaryOperator countingH = x -> Math.abs(x / columns - dest / columns) + Math.abs(x % columns - dest % columns);

        openList.add(new Node(src, 0, countingH.applyAsInt(src), new Node()));
        while(!openList.isEmpty()){
            Node n = openList.poll();
            if(visited[n.p]){
                continue;
            }
            visited[n.p] = true;
            int dis = Math.max(Math.abs(dest / columns - n.p / columns), Math.abs(dest % columns - n.p % columns));
            if(dis <= atkRange){
                return resolvePath(n);
            }
            updateFringe(map, columns, n, countingH, openList, visited);
        }
        return new int[0];
    }

    private static int[] resolvePath(Node last){
        Deque<Integer> path = new ArrayDeque<>();
        Node c = last;
        while(c.parent != null){
            path.push(c.p);
            c = c.parent;
        }
        int[] result = new int[path.size()];
        int i = 0;
        while(!path.isEmpty()){
            result[i++] = path.pop();
        }
        return result;
    }

    private static void updateFringe(int[] map, int columns, Node n, IntUnaryOperator countingH, PriorityQueue<Node> openList, boolean[] visited){
        int[] adjacency;
        if(n.p % columns == 0){
            adjacency = new int[]{n.p + 1, n.p - columns, n.p + columns};
        }
        else if (n.p % columns == columns - 1){
            adjacency = new int[]{n.p - 1, n.p - columns, n.p + columns};
        }
        else{
            adjacency = new int[]{n.p - 1, n.p + 1, n.p - columns, n.p + columns};
        }

        for(int adj : adjacency){
            if(adj < 0 || adj >= map.length || map[adj] == 1 || visited[adj]){
                continue;
            }
            openList.add(new Node(adj, n.g + 1, countingH.applyAsInt(adj), n));
        }
    }

    private Algorithms(){}
}


class Node implements Comparable<Node>{
    Node(int p, int g, int h, Node parent){
        this.p = p;
        this.g = g;
        this.f = g + h;
        this.parent = parent;
    }

    Node(){
        p = -1;
        f = -1;
        g = -1;
        parent = null;
    }

    @Override
    public int compareTo(Node other){
        return ComparisonChain.start().
        compare(this.f, other.f).
        compare(this.g, other.g).
        compare(this.p, other.p).
        result();
    }

    final int p;
    final int g;
    final int f;
    final Node parent;
}

