package ooFoundation;

import Sort.Sort;

import java.util.List;

/**
 * @author ：杨海洋
 * @date ：Created in 2020/9/16 13:23
 * @description：葫芦娃类
 * @modified By：
 * @version: $
 */
public class GourdBaby {
    private String name;
    private int id;

    public GourdBaby() {
    }

    public GourdBaby(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void sort(List<GourdBaby> list){
        List<GourdBaby> gB = Sort.sort2(list);
        System.out.println("葫芦娃们自己排序之后进行报数：");
        for(int i=0;i<gB.size();i++){
            System.out.print(gB.get(i).getName());
            if(i!=gB.size()-1)
                System.out.print(",");
        }
    }
}
