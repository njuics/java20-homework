import java.util.Random;

public class Solution {
    private static void Shuffle(Object[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int rand = random.nextInt(7);
            if(i!=rand){
                Object temp = array[i];
                array[i] = array[rand];
                array[rand] = temp;
            }
        }
    }
    public static void choreographySort(CalabashBrother[] brothersArray)
    {
        System.out.println("葫芦娃协同排序，排序前报数：");
        for (CalabashBrother calabashBrother : brothersArray)
            calabashBrother.numberOff();
        System.out.println();

        for(int i = 0;i<brothersArray.length-1;i++)
            for(int j = 0;j<brothersArray.length-1-i;j++)
                if(!brothersArray[j].compare(brothersArray[j+1]))
                    brothersArray[j].swap(brothersArray[j+1]);

        System.out.println("排好序后报数：");
        for (CalabashBrother calabashBrother : brothersArray)
            calabashBrother.numberOff();
        System.out.println();
    }
    public static void main(String[] args){
        CalabashBrother[] brothersArray = new CalabashBrother[7];
        for(int i = 0; i < 7; i++)
            brothersArray[i] = new CalabashBrother(i+1);
        Shuffle(brothersArray);
        GrandFather grandFather = new GrandFather();
        grandFather.SortBrothers(brothersArray);
        Shuffle(brothersArray);
        choreographySort(brothersArray);
    }
}
