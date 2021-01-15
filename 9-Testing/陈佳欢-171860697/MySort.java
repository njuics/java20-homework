import java.util.Vector;

public class MySort {

    MySort() {}

    public void orchestration(Vector<Position<Creature>> list) {
        for(int i = 0;i < list.size();i++) {
            if(list.get(i).get_creature().walk()!=i) {
                int position = list.get(i).get_creature().walk();
                while(position != i) {
                    Creature temp = list.get(position).get_creature();
                    list.get(position).position_replace(list.get(i).get_creature());
                    list.get(i).position_replace(temp);
                    position = temp.walk();
                }
            }
        }
    }

    public void choreography(Vector<Position<Creature>> list) {
        //每个人根据自己的walk函数，走到对应的位置
        for(int i = 0;i < list.size();i++) {
            if(list.get(i).get_creature().walk()!=i) {
                int position = list.get(i).get_creature().walk();
                while(position != i) {
                    Creature temp = list.get(position).get_creature();
                    list.get(position).position_replace(list.get(i).get_creature());
                    list.get(i).position_replace(temp);
                    position = temp.walk();
                }
            }
        }
    }
    
}
