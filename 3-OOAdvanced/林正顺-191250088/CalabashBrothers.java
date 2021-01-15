//package 林正顺-191250088.3-OOAdvanced.java20-homework.linzs148;

public class CalabashBrothers {

    private static int count;
    private int number;
    private String name;
    //number记录葫芦娃的排行
    //name记录葫芦娃的名字
    //count记录已经出生的葫芦娃的数量

    static{
        count = 0;
    }

    public static int getCount() {
        return count;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }


    public CalabashBrothers(int number, String name){

        count++;
        assert ((number >= 1) && (number <= 7));
        //总不会有八个葫芦娃吧？（雾
        this.number = number;
        this.name = name;

    }
    //构造函数
    //造出一个葫芦娃，给出该娃的排行和名字


    public CalabashBrothers(int number){

        count++;
        assert ((number >= 1) && (number <= 7));
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
    //重载构造函数
    //当爷爷取名字没啥灵感的时候就直接按照排行作为名字吧。。。


    public static void changePlace(CalabashBrothers onecalbashbrother, CalabashBrothers othercalbashbrother){
        int oneNumber = onecalbashbrother.getNumber(), otherNumber = othercalbashbrother.getNumber();
        String oneName = onecalbashbrother.getName(), otherName = othercalbashbrother.getName();

        onecalbashbrother.setNumber(otherNumber);
        onecalbashbrother.setName(otherName);
        othercalbashbrother.setNumber(oneNumber);
        othercalbashbrother.setName(oneName);
    }
    //乖巧的葫芦娃听话地换了一下位置
    //不乖巧的葫芦娃被爷爷打了一顿并交换了一下位置


    public static void lineUpByOurseives(CalabashBrothers[] brothers){
        Sort sort = new CalabashBrothersSort();
        sort.Sort(brothers, 0, 6);
    }
    //葫芦娃自己排队

    public static void main(String[] args) {
        int[] idx = {5, 1, 4, 3, 2, 6, 7};
        CalabashBrothers[] brothers = new CalabashBrothers[7];

        for (int i = 0; i < 7; i++) {
            brothers[i] = new CalabashBrothers(idx[i]);
            System.out.println(brothers[i].getName());
        }
        //生出了7只葫芦娃

        CalabashBrothers.lineUpByOurseives(brothers);

        System.out.println("---");

        for (int i = 0; i < 7; i++) {
            System.out.println(brothers[i].getName());
        }
    }
}
