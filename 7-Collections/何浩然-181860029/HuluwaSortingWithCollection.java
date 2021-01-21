import java.util.*;
public class HuluwaSortingWithCollection{//用集合接口来实现葫芦娃的排序
    public static  void main(String[] args){
        List<Huluwa> h=new ArrayList<Huluwa>();//总的葫芦娃队伍
        List<Huluwa> h_man=new ArrayList<Huluwa>();//男性葫芦娃所在
        List<Huluwa> h_woman=new ArrayList<Huluwa>();//女性葫芦娃所在
        Huluwa[] huluwa=new Huluwa[7];
        
        for(int i=0;i<huluwa.length;i++){
            huluwa[i]=new Huluwa(huluwa.length-i);
            h.add(huluwa[i]);//加入原来的7个葫芦娃
        }
        h_add(h,3);//随机生成三个葫芦娃
        h_divide(h, h_man, h_woman);//按性别分组
        System.out.println("乱序为：");
        for(int i=0;i<h.size();i++){
            System.out.print(h.get(i).name+' ');
        }
        System.out.println("");
        System.out.println("正序为：");
        h_sort(h);

        System.out.println("");
        System.out.println("反序为：");
        h_sort_reverse(h);
        
        System.out.println("");
        System.out.println("性别为男的排序为：");
        h_sort(h_man);
        System.out.println("");
        System.out.println("性别为女的排序为：");
        h_sort(h_woman);

      
    }


    static void h_add(List<Huluwa> h, int num){
        for (int i=0;i<num;i++){
        Huluwa p=new Huluwa();
        h.add(p);
        }
        
    }
    static void h_divide(List<Huluwa>h, List<Huluwa>h_man, List<Huluwa>h_woman){
        for(int i=0;i<h.size();i++){
            if(h.get(i).sex==false){
                h_woman.add(h.get(i));
            }
            else{
                h_man.add(h.get(i));
            }
        } 
    }
    static void h_sort(List<Huluwa>h){
        h.sort(new HuluwaComparator());
        Iterator<Huluwa>it=h.iterator();
        while(it.hasNext()){//下标后移，判断是否有数据
            System.out.print(it.next().name+' ');
        }
        
    }
    static void h_sort_reverse(List<Huluwa>h){
        h.sort(new HuluwaComparator1());
        Iterator<Huluwa>it=h.iterator();
        while(it.hasNext()){//下标后移，判断是否有数据
            System.out.print(it.next().name+' ');
        }
        
    }

}