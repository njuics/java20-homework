package OOFoundation;

public class WorldMain {



    public static void main(String[] args) {
        HuluWa h1 = new HuluWa(1, "老大");
        HuluWa h2 = new HuluWa(2, "老二");
        HuluWa h3 = new HuluWa(3, "老三");
        HuluWa h4 = new HuluWa(4, "老四");
        HuluWa h5 = new HuluWa(5, "老五");
        HuluWa h6 = new HuluWa(6, "老六");
        HuluWa h7 = new HuluWa(7, "老七");

        HuluWa[] array = new HuluWa[]{h3, h1, h2, h7, h4, h5, h6};
        callHuluWa(array);

        Grandpa grandpa = new Grandpa();
        grandpa.sortHuluwa(array);
        callHuluWa(array);

        array = new HuluWa[]{h3, h1, h2, h7, h4, h5, h6};
        callHuluWa(array);
        callHuluWa(sortHuluWa(array));
    }

    public static void callHuluWa(HuluWa[] array){
        for(int i = 0 ;i<array.length;i++){
            array[i].call();
        }
        System.out.println();
    }

    public static HuluWa[] sortHuluWa(HuluWa[] array){
        HuluWa[] huluwa = new HuluWa[array.length];
        for(int i = 0;i<array.length;i++){
            huluwa[array[i].getIndex(array)] = array[i];
        }
        return huluwa;
    }



}
