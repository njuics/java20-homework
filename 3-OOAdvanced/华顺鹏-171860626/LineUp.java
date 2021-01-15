import java.util.Scanner;
import hsp.java.nju.*;
public class LineUp {
    public static void main(String[] args)
    {
        System.out.println("请输入葫芦七兄弟的初始队形,形式：老大 老二 ...");
        Scanner input=new Scanner(System.in);
        String str=new String();
        str=input.nextLine();
        String[] huluranknames=str.split("\\s+");
        Human[] hulubro=new Hulu[huluranknames.length];
        Grandpa grandpa=new Grandpa();
        for(int i=0;i<huluranknames.length;i++)
        {
            hulubro[i]=new Hulu(huluranknames[i],i);
        }
        for(int i=0;i<hulubro.length-1;i++)
        {
            for(int j=hulubro.length-2;j>=i;j--)
            {
                //sort 1,orchestration
                int ret=grandpa.command((Hulu)hulubro[j],(Hulu)hulubro[j+1]);

                //sort 2 ,choreography
                //int ret=hulubro[j].communicate((Hulu) hulubro[j+1]);
                if(ret==2)
                {
                    Human tmp=hulubro[j];
                    hulubro[j]=hulubro[j+1];
                    hulubro[j+1]=tmp;
                }
            }
        }
        System.out.println();
        System.out.println("队伍整理结束,开始报数：");
        for(int i=0;i<hulubro.length;i++) {
            System.out.print(hulubro[i].getName());
            System.out.print(" ");
        }
    }
}
