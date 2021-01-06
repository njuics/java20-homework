import java.util.Comparator;
import java.util.Arrays;
import java.util.Random;
import java.lang.Comparable;

public class HuluwaSort {
    public static void main(String[] args){
        OrchestrationWorld orchestrationWorld = new OrchestrationWorld();
        ChoreographyWorld  choreographyWorld  = new ChoreographyWorld();
        orchestrationWorld.run();
        choreographyWorld.run();
    }
}


class Huluwa implements Comparable<Huluwa>{
    private String name;
    private int age;
    Huluwa(){
        this.name = null;
        this.age = 0;
    }
    Huluwa(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void report(){
        System.out.print(this.name + " ");
    }

    public int getAge(){
        return this.age;
    }

    @Override
    public int compareTo(Huluwa bro){
        return bro.getAge() - this.age;
    }

    public void swapWith(Huluwa bro){
        String tmp_name = this.name;
        this.name = bro.name;
        bro.name = tmp_name;
        int tmp_age = this.age;
        this.age = bro.age;
        bro.age = tmp_age;
    }
}



class GrandFather{
    
    public Huluwa[] plantHuluwa(){
        Huluwa[] grandsons = new Huluwa[]{
            new Huluwa("大娃", 7),
            new Huluwa("二娃", 6),
            new Huluwa("三娃", 5),
            new Huluwa("四娃", 4),
            new Huluwa("五娃", 3),
            new Huluwa("六娃", 2),
            new Huluwa("七娃", 1),
        };
        return grandsons;
    }
    public void randomShuffle(Huluwa[] grandsons,int shuffle_times){
        Random random = new Random();
        for(int i=0; i<shuffle_times; ++i){
            int a = random.nextInt(7);
            int b = random.nextInt(7);
            if(a == b)continue;
            Huluwa tmp = new Huluwa();
            tmp = grandsons[a];
            grandsons[a] = grandsons[b];
            grandsons[b] = tmp;
        }
    }

    private static Comparator<Huluwa> observer = new Comparator<Huluwa>(){
        @Override
        public int compare(Huluwa a,Huluwa b){
            return b.getAge() - a.getAge();
        }
    };

    public void sortHuluwa(Huluwa[] grandsons){
        //Arrays.sort(grandsons, observer);
        mySort(grandsons, observer);
    }

    private void mySort(Huluwa[] grandsons, Comparator<Huluwa> cmp){
        int n = grandsons.length;
        for(int i=0;i<n;++i){
            for(int j=0;j<n-1;++j){
                if(cmp.compare(grandsons[j], grandsons[j+1])>0){
                    Huluwa tmp = new Huluwa();
                    tmp = grandsons[j];
                    grandsons[j] = grandsons[j+1];
                    grandsons[j+1] = tmp;
                }
            }
        }
    }

    public void reportInOrder(Huluwa[] grandsons){
        for(Huluwa a:grandsons){
            a.report();
        }
        System.out.println();
    }
}

class OrchestrationWorld{
    public void run(){
        System.out.println("Orchestration World run");
        GrandFather grandFather = new GrandFather();
        Huluwa[] huluwas = grandFather.plantHuluwa();
        grandFather.randomShuffle(huluwas, 20);
        grandFather.reportInOrder(huluwas);
        grandFather.sortHuluwa(huluwas);
        grandFather.reportInOrder(huluwas);
    }
}

class ChoreographyWorld{
    public void run(){
        System.out.println("Choreography World run");
        Huluwa[] huluwas = new Huluwa[]{
            new Huluwa("大娃", 7),
            new Huluwa("二娃", 6),
            new Huluwa("三娃", 5),
            new Huluwa("四娃", 4),
            new Huluwa("五娃", 3),
            new Huluwa("六娃", 2),
            new Huluwa("七娃", 1),
        };

        randomShuffle(huluwas, 20);
        for(Huluwa huluwa:huluwas){
            huluwa.report();
        }
        System.out.println();

        //Arrays.sort(huluwas);
        HuluwaSort(huluwas);

        for(Huluwa huluwa:huluwas){
            huluwa.report();
        }
        
    }

    private void randomShuffle(Huluwa[] huluwas,int shuffle_times){
        Random random = new Random();
        for(int i=0; i<shuffle_times; ++i){
            int a = random.nextInt(7);
            int b = random.nextInt(7);
            if(a == b)continue;
            huluwas[a].swapWith(huluwas[b]);
            /*
            Huluwa tmp = new Huluwa();
            tmp = huluwas[a];
            huluwas[a] = huluwas[b];
            huluwas[b] = tmp;
            */
        }
    }


    private void HuluwaSort(Huluwa[] huluwas){
        int n = huluwas.length;
        for(int i=0;i<n;++i){
            for(int j=0;j<n-1;++j){
                if(huluwas[j].compareTo(huluwas[j+1])>0){
                    huluwas[j].swapWith(huluwas[j+1]);
                    /*
                    Huluwa tmp = new Huluwa();
                    tmp = huluwas[j];
                    huluwas[j] = huluwas[j+1];
                    huluwas[j+1] = tmp;
                    */
                }
            }
        }
    }
}




