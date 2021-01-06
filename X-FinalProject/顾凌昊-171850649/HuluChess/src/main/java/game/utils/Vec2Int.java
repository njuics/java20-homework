package game.utils;

public class Vec2Int {

    public int x,y;

    public Vec2Int(int a, int b){
        x = a;
        y = b;
    }

    public Vec2Int plus(Vec2Int v){
        return new Vec2Int(x+v.x, y+v.y);
    }

    public Vec2Int minus(Vec2Int v){
        return new Vec2Int(x-v.x, y-v.y);
    }

}
