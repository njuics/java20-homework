public class CalabashBoysSort {
    public static void main(String []args){
        CalabashBoy[] calabashBoys = new CalabashBoy[7];
        for(int i = 0; i < 7; i++){
            calabashBoys[i] = new CalabashBoy((i + 3)%7);
        }

        Functions func = new Functions();
        //choreography,自己排序
        //calabashBoys = func.Sort(calabashBoys);

        //orchestration,爷爷排序
        Grandfather gf = new Grandfather();
        calabashBoys = gf.BoysSort(calabashBoys);

        func.OutPut(calabashBoys);

    }


}

class Functions{
    CalabashBoy [] Swap(CalabashBoy[] boys, int l, int r){
        CalabashBoy tmp = boys[l];
        boys[l] = boys[r];
        boys[r] = tmp;
        return boys;
    }
    void OutPut(CalabashBoy[] boys){
        for(int i = 0; i < 7; i++){
            boys[i].outPut();
        }
    }
    CalabashBoy [] Sort(CalabashBoy[] boys){
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6 - i; j++){
                if(boys[j].rank > boys[j + 1].rank){
                    boys = Swap(boys, j, j + 1);
                }
            }
        }
        return boys;
    }
}

class CalabashBoy{
    public String name;
    public int rank;
    CalabashBoy(int rank){
        this.rank = rank;
        switch (rank){
            case 0:
                this.name = "老大";
                break;
            case 1:
                this.name = "老二";
                break;
            case 2:
                this.name = "老三";
                break;
            case 3:
                this.name = "老四";
                break;
            case 4:
                this.name = "老五";
                break;
            case 5:
                this.name = "老六";
                break;
            case 6:
                this.name = "老七";
                break;
        }

    }

    void outPut(){
        System.out.println(this.name);
    }
}

class Grandfather{
    CalabashBoy [] BoysSort(CalabashBoy[] boys){
        Functions func = new Functions();
        for(int i = 0; i < 6; i++){
            int tmp = i;
            for(int j = i + 1; j < 7; j++){
                tmp = boys[tmp].rank < boys[j].rank ? tmp : j;
            }
            boys = func.Swap(boys, tmp, i);
        }

        return boys;
    }
}
