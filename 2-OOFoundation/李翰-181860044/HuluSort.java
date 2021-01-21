import java.util.Random;

class HuLu {
    private String name;
    private int rank;

    HuLu(String name, int rank){
        this.name = name;
        this.rank = rank;
    }

    public int getRank(){
        return this.rank;
    }

    public int getOtherRank(HuLu hulu){
        return hulu.getRank();
    }

    public void exchangePos(HuLu hulu){
        String tmpName = hulu.name;
        hulu.name = this.name;
        this.name = tmpName;
        int tmpRank = hulu.rank;
        hulu.rank = this.rank;
        this.rank = tmpRank;
    }

    public void soundOff(){
        System.out.print(this.name + ' ');
    }
}

class Grandpa {
    public boolean cmp(HuLu a, HuLu b) {
        if(a.getRank() > b.getRank())
            return true;
        else 
            return false;
    }

    public void command(HuLu []hulu, int i, int j) {
        HuLu tmp = hulu[i];
        hulu[i] = hulu[j];
        hulu[j] = tmp;
    }
}

class Orchestration {
    public void sort(HuLu []hulu){
        Grandpa grandpa = new Grandpa();
        for (int i=0; i < 6; ++i)
            for (int j=0; j < 6-i; ++j)
            {
                if (grandpa.cmp(hulu[j],hulu[j + 1]))
                {
                    grandpa.command(hulu, j, j+1);
                }
            }
    }
}

class Choreography {
    public void sort(HuLu []hulu){
        for (int i=0; i < 6; ++i)
            for (int j=0; j < 6-i; ++j)
            {
                int otherRank = hulu[j].getOtherRank(hulu[j + 1]);
                if (hulu[j].getRank() > otherRank)
                {
                    hulu[j].exchangePos(hulu[j+1]);
                }
            }
    }
}

public class HuluSort {
    public static void main(String[] args) {
        Random random = new Random();

        HuLu []hulu = new HuLu[7];
        HuLu hulu1 = new HuLu("老大", 1);
        HuLu hulu2 = new HuLu("老二", 2);
        HuLu hulu3 = new HuLu("老三", 3);
        HuLu hulu4 = new HuLu("老四", 4);
        HuLu hulu5 = new HuLu("老五", 5);
        HuLu hulu6 = new HuLu("老六", 6);
        HuLu hulu7 = new HuLu("老七", 7);

        hulu[0] = hulu1;
        hulu[1] = hulu2;
        hulu[2] = hulu3;
        hulu[3] = hulu4;
        hulu[4] = hulu5;
        hulu[5] = hulu6;
        hulu[6] = hulu7;

        System.out.println("orchestration:");
        System.out.print("Before Sort:");
        for(int index=6; index>=0; index--) {       
            int randomNum = random.nextInt(index+1);
            HuLu tmp = hulu[randomNum];
            hulu[randomNum] = hulu[index];
            hulu[index] = tmp;
        }  
        for(int i=0; i<7; i++){
            hulu[i].soundOff();
        }
        System.out.println();
 
        Orchestration orchestration = new Orchestration();
        orchestration.sort(hulu);

        System.out.print("After Sort:");
        for(int i=0; i<7; i++){
            hulu[i].soundOff();
        }
        System.out.println();


        System.out.println("choreography:");
        System.out.print("Before Sort:");
        for(int index=6; index>=0; index--) {       
            int randomNum = random.nextInt(index+1);
            HuLu tmp = hulu[randomNum];
            hulu[randomNum] = hulu[index];
            hulu[index] = tmp;
        }  
        for(int i=0; i<7; i++){
            hulu[i].soundOff();
        }
        System.out.println();
 
        Choreography choreography = new Choreography();
        choreography.sort(hulu);

        System.out.print("After Sort:");
        for(int i=0; i<7; i++){
            hulu[i].soundOff();
        }
        System.out.println();

    }
}
