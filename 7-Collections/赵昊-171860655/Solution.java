import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import character.*;
public class Solution {
    private  static ArrayList<CalabashBrother> brothersArray;
    private static void Shuffle(ArrayList<CalabashBrother> array) {
        Random random = new Random();
        for (int i = array.size() - 1; i > 0; i--) {
            int rand = random.nextInt(7);
            if(i!=rand){
                CalabashBrother temp = array.get(i);
                array.set(i,array.get(rand));
                array.set(i,temp);
            }
        }
    }
    public static void choreographySort(ArrayList<CalabashBrother> brothersArray)
    {
        System.out.println("葫芦娃协同排序，排序前报数：");
        for (CalabashBrother calabashBrother : brothersArray)
            calabashBrother.numberOff();
        System.out.println();

        for(int i = 0;i<brothersArray.size()-1;i++)
            for(int j = 0;j<brothersArray.size()-1-i;j++)
                if(brothersArray.get(j).compare(brothersArray.get(j+1))>0)
                    brothersArray.get(j).swap(brothersArray.get(j+1));

        System.out.println("排好序后报数：");
        for (CalabashBrother calabashBrother : brothersArray)
            calabashBrother.numberOff();
        System.out.println();
    }
    public static void main(String[] args){
        brothersArray =new ArrayList<CalabashBrother>();

        int CalabashBrotherNum=15;
        for(int i=0;i<CalabashBrotherNum;i++){
            Random r1=new Random();
            int randomRank=r1.nextInt(7);
            int length=r1.nextInt(5)+4;
            String randomName;
            String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            Random random=new Random();
            StringBuilder sb=new StringBuilder();
            for(int k=0;k<length;k++){
                int number=random.nextInt(62);
                sb.append(str.charAt(number));
            }
            randomName = sb.toString();
            int randomGender=r1.nextInt(2);
            brothersArray.add(new CalabashBrother(randomRank,randomName,randomGender));
        }


        ArrayList<CalabashBrother> maleArray=new ArrayList<CalabashBrother>();
        ArrayList<CalabashBrother> femaleArray=new ArrayList<CalabashBrother>();
        for(CalabashBrother e:brothersArray){
            if(e.getGender()==0)femaleArray.add(e);
            else maleArray.add(e);
        }
        System.out.println("全部排序前：");
        for (CalabashBrother calabashBrother : brothersArray)
            calabashBrother.numberOff();
        System.out.println("");
        Collections.sort(brothersArray);
        Collections.sort(femaleArray);
        Collections.sort(maleArray);
        System.out.println("全部排序后");
        for (CalabashBrother calabashBrother : brothersArray)
            calabashBrother.numberOff();
        System.out.println("");
        System.out.println("男葫芦娃排序后");
        for(CalabashBrother e:maleArray){
            System.out.print(e.getName()+" ");
        }
        System.out.println("");

        System.out.println("女葫芦娃排序后");
        for(CalabashBrother e:femaleArray){
            System.out.print(e.getName()+" ");
        }
        System.out.println("");

     //   GrandFather grandFather = new GrandFather();
     //   grandFather.SortBrothers(brothersArray);
     //   Shuffle(brothersArray);
     //   choreographySort(brothersArray);
    }
}
