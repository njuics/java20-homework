public class CalabashBrothers {

    private int number;
    private String name;
    //public int index;
    //number记录葫芦娃的排行
    //name记录葫芦娃的名字
    //index记录葫芦娃在队伍中的位置

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public CalabashBrothers(int number){
        this.number = number;

        switch (number){
            case 1:
                name = "老大";
                break;
            case 2:
                name = "老二";
                break;
            case 3:
                name = "老三";
                break;
            case 4:
                name = "老四";
                break;
            case 5:
                name = "老五";
                break;
            case 6:
                name = "老六";
                break;
            case 7:
                name = "老七";
                break;
        }
    }


    public static void lineUpByOurseives(CalabashBrothers[] brothers){
        Sort sort = new BubbleSort();
        sort.concreteSort(brothers, 0, 6);
    }

    public static void main(String[] args) {
        int[] idx = {5, 1, 4, 3, 2, 6, 7};
        CalabashBrothers[] brothers = new CalabashBrothers[7];

        for(int i = 0; i < 7; i++){
            brothers[i] = new CalabashBrothers(idx[i]);
            System.out.println(brothers[i].getName());
        }

        CalabashBrothers.lineUpByOurseives(brothers);

        System.out.println("---");

        for (int i = 0; i < 7; i++) {
            System.out.println(brothers[i].getName());
        }
    }
}
