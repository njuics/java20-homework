package CalabashBrother;

public class CalabashBrother {
    /*public enum Color{
        RED,ORENGE,YELLOW,GREEN,CYAN,BLUE,PURPLE;
    }*/
    private int color;
    private int index;
    private static int count = 0;

    private String[] calabashbrothernames={"老大","老二","老三","老四","老五","老六","老七"};

    public CalabashBrother(int index){
        this.index = count++%7;
        this.color = index;
    }

    public  void Sort(CalabashBrother[] calabashBrothers){
        int i = this.index;
        for(int j = 0;j < calabashBrothers.length -1 - i;j++){
            if(calabashBrothers[j].getColor() > calabashBrothers[j + 1].getColor()){
                CalabashBrother temp = calabashBrothers[j + 1];
                calabashBrothers[j+1] = calabashBrothers[j];
                calabashBrothers[j] = temp;
                int tmp = calabashBrothers[j+1].index;
                calabashBrothers[j+1].index = calabashBrothers[j].index;
                calabashBrothers[j].index = tmp;
            }
            if(i < calabashBrothers.length - 1)calabashBrothers[i + 1].Sort(calabashBrothers);
        }

    }

    public int getIndex(){
        return index;
    }

    public  int getColor(){
        return color;
    }

    public String getname(){
        return calabashbrothernames[this.color-1];
    }

    public static void print(CalabashBrother[] calabashBrothers){
        for(CalabashBrother cb : calabashBrothers) {
            System.out.printf("%s%d%c",cb.getname(),cb.getColor(),' ');
        }
    }
}
