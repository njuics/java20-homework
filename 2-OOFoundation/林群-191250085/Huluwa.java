public class Huluwa {
    private int order;//葫芦娃排名
    private String name;


    Huluwa(int order, String name) {
        this.order = order;
        this.name = name;
    }

    void setOrder(int order){this.order = order;}

    int getOrder(){return this.order;}

    //报数
    void number(){
        System.out.println(name);
        // switch (this.order){
        //     case 1:
        //         System.out.print("老大 ");
        //         break;
        //     case 2:
        //         System.out.print("老二 ");
        //         break;
        //     case 3:
        //         System.out.print("老三 ");
        //         break;
        //     case 4:
        //         System.out.print("老四 ");
        //         break;
        //     case 5:
        //         System.out.print("老五 ");
        //         break;
        //     case 6:
        //         System.out.print("老六 ");
        //         break;
        //     case 7:
        //         System.out.print("老七 ");
        //         break;
        //     default:
        //         break;
        //     }
        }

        boolean compare(Huluwa huluwa) {
            return this.order > huluwa.getOrder();
        }

        void swap(Huluwa huluwa) {
            int temp = huluwa.getOrder();
            huluwa.setOrder(this.order);
            this.order = temp;
        }
    }
