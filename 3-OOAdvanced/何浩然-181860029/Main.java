public class Main {
    public static void main(String[]args){
        Human[] people=new Human[1];
        people[0]=new Human("爷爷");

        Huluwa[] huluwa=new Huluwa[7];
        System.out.print("未排序前的顺序: ");
        for(int i=0;i<huluwa.length;i++){
           huluwa[i]=new Huluwa(huluwa.length-i);
           System.out.print(huluwa[i].name+" ");
        }
        people[0].sort(huluwa);
        System.out.println("\n"+"orchestration排序后数组：");
        for(int i=0;i<huluwa.length;i++){
            System.out.print(huluwa[i].name+" ");
        }
        //
        System.out.print("\n"+"未排序前的顺序: ");
        for(int i=0;i<huluwa.length;i++){
           huluwa[i]=new Huluwa(huluwa.length-i);
           huluwa[i].pos=i;
           System.out.print(huluwa[i].name+" ");
        }
        int j=huluwa.length;
        while(j>1){
            for(int i=0;i<j;i++){
                huluwa[i].sort(huluwa);
            }
            j--;
        }
        System.out.println("\n"+"choreography排序后数组：");
        for(int i=0;i<huluwa.length;i++){
            System.out.print(huluwa[i].name+" ");
        }

    }
}