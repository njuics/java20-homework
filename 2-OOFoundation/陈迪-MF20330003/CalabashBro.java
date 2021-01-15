import java.util.Random;
public class CalabashBro {

    public static void randSort(Brother[] pos){
        Random rand = new Random();
        for(int i = 0; i < 7; i++){
            int rand_id = rand.nextInt(7);
            pos[i].exchange(pos[rand_id]);//随机找一个人换位置
            Brother temp = pos[i];
            pos[i] = pos[rand_id];
            pos[rand_id] = temp;
        }
        System.out.println("随机站队完成，开始报数！");
        for(int i = 0; i < 7 ; i++){
            pos[i].yell();
        }
        System.out.print("\n");
    }

    public static void orchestration(Brother[] pos){
        System.out.println("orchestration world");
        randSort(pos);//随机站队
        // 冒泡排序
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7 - i - 1; j++){
                if(pos[j].get_rank() > pos[j+1].get_rank()){
                    pos[j].exchange(pos[j+1]);
                    Brother temp = pos[j];
                    pos[j] = pos[j+1];
                    pos[j+1] = temp;
                }
            }
        }
        System.out.println("自行排队完成，开始报数！");
        for(int i = 0; i < 7 ; i++){
            pos[i].yell();
        }
        System.out.print("\n");
    }

    public static void choreography(Brother[] pos){
        System.out.println("choreography world");
        Grandpa grandpa = new Grandpa();
        randSort(pos);//随机站队
        grandpa.grandpa_sort(pos);
        System.out.println("爷爷组织排队完成，开始报数！");
        grandpa.start_yell(pos);
    }

    public static void main(String[] argv){
        //实例化七兄弟
        //初始位置：老大第一个，老七最后
        String[] name = {"老大","老二","老三","老四","老五","老六","老七"};
        Brother[] pos_temp = new Brother[7];//记录当前队伍顺序
        for(int i = 0; i < 7; i++){
            pos_temp[i] = new Brother(name[i],i+1,i);
        }
        
        orchestration(pos_temp);
        choreography(pos_temp);
    }
}
