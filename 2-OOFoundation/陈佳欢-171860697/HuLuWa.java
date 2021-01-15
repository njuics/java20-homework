import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

enum Name_of_Hulu {
    ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN
}

class Hulu{
    Name_of_Hulu name;      /*葫芦娃的名字，枚举类型*/

    int rank;       /*葫芦娃的排名，方便排位*/

    public Hulu(Name_of_Hulu name1){        /*构造函数*/
        this.name = name1;
        switch(this.name){
            case ONE:
                this.rank = 1;
                break;
            case TWO:
                this.rank = 2;
                break;
            case THREE:
                this.rank = 3;
                break;
            case FOUR:
                this.rank = 4;
                break;
            case FIVE:
                this.rank = 5;
                break;
            case SIX:
                this.rank = 6;
                break;
            default:
                this.rank = 7;
        }
    }

    public Hulu(Hulu huluwa){
        this.name = huluwa.name;
        this.rank = huluwa.rank;
    }
}

class Brothers{
    List<Hulu> Brothers = new ArrayList<>();

    public Brothers(){
        Brothers.add(new Hulu(Name_of_Hulu.ONE));
        Brothers.add(new Hulu(Name_of_Hulu.TWO));
        Brothers.add(new Hulu(Name_of_Hulu.THREE));
        Brothers.add(new Hulu(Name_of_Hulu.FOUR));
        Brothers.add(new Hulu(Name_of_Hulu.FIVE));
        Brothers.add(new Hulu(Name_of_Hulu.SIX));
        Brothers.add(new Hulu(Name_of_Hulu.SEVEN));
    }

    public void printout(){
        String output = "";
        for(int i=0;i<this.Brothers.size();i++){
            switch(this.Brothers.get(i).name){
                case ONE:
                    output += "大娃 ";
                    break;
                case TWO:
                    output += "二娃 ";
                    break;
                case THREE:
                    output += "三娃 ";
                    break;
                case FOUR:
                    output += "四娃 ";
                    break;
                case FIVE:
                    output += "五娃 ";
                    break;
                case SIX:
                    output += "六娃 ";
                    break;
                default:
                    output += "七娃 ";
            }
        }
        System.out.println(output);
    }

    public void choreography(){
        for(int i=0;i<Brothers.size();i++){
            for(int j=i+1;j<Brothers.size();j++){
                if(Brothers.get(i).rank<Brothers.get(j).rank){
                    Hulu huluwa = new Hulu(Brothers.get(i));
                    Brothers.set(i, Brothers.get(j));
                    Brothers.set(j, huluwa);
                }
            }
        }
    }
}

class GrandPa{
    public GrandPa(){}

    void orchestration(List<Hulu> Brothers){
        for(int i=0;i<Brothers.size();i++){
            for(int j=i+1;j<Brothers.size();j++){
                if(Brothers.get(i).rank>Brothers.get(j).rank){
                    Hulu huluwa = new Hulu(Brothers.get(i));
                    Brothers.set(i, Brothers.get(j));
                    Brothers.set(j, huluwa);
                }
            }
        }
    }
}

public class HuLuWa {

    public static void main(String[] args) {
        //构建对象葫芦娃七兄弟
        Brothers brothers = new Brothers();

        //随机站队
        System.out.println("随机站队结果：");
        Collections.shuffle(brothers.Brothers);
        brothers.printout();

        //爷爷指挥葫芦娃们站队
        System.out.println("葫芦爷爷指挥站队结果：");
        GrandPa grandpa = new GrandPa();
        grandpa.orchestration(brothers.Brothers);
        brothers.printout();

        //葫芦兄弟们自发站队
        System.out.println("葫芦兄弟自发站队结果：");
        brothers.choreography();
        brothers.printout();
    }
}
