import java.util.Vector;

public class Main {

    private static Vector<Position<Creature>> chessboard = new Vector<Position<Creature>>(10*10);

    public static void init() {
        GrandPa grandpa = new GrandPa();
        One_Huluwa one = new One_Huluwa();
        Two_Huluwa two = new Two_Huluwa();
        Three_Huluwa three = new Three_Huluwa();
        Four_Huluwa four = new Four_Huluwa();
        Five_Huluwa five = new Five_Huluwa();
        Six_Huluwa six = new Six_Huluwa();
        Seven_Huluwa seven = new Seven_Huluwa();
        chessboard.add(new Position<Creature>(0, 0, grandpa));
        chessboard.add(new Position<Creature>(0, 1, one));
        chessboard.add(new Position<Creature>(0, 2, two));
        chessboard.add(new Position<Creature>(0, 3, three));
        chessboard.add(new Position<Creature>(0, 4, four));
        chessboard.add(new Position<Creature>(0, 5, five));
        chessboard.add(new Position<Creature>(0, 6, six));
        chessboard.add(new Position<Creature>(0, 7, seven));
    }

    static void print() {
        for(int i=0;i<chessboard.size();i++){
            System.out.println(chessboard.get(i).get_creature().get_name());
        }
    }

    public static void main(String[] args) {

        init();     /* 初始化棋盘，葫芦娃们都在第一行第一列 */
        print();    /* 输出棋盘信息 */
        
        System.out.println("Program Finished!");
    }
    
}