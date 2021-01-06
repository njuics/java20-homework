public class Grandpa {
    public void grandpa_sort(Brother[] pos){
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7 - i - 1; j++){
                if(pos[j].get_rank() > pos[j+1].get_rank()){
                    //爷爷指定位置
                    int pos1 = pos[j].get_pos();
                    int pos2 = pos[j+1].get_pos();
                    pos[j].set_pos(pos2);
                    pos[j+1].set_pos(pos1);
                    //记录当前队伍
                    Brother temp = pos[j];
                    pos[j] = pos[j+1];
                    pos[j+1] = temp;
                }
            }
        }
    }
    public void start_yell(Brother[] pos){
        for(int i = 0; i < 7 ; i++){
            pos[i].yell();
        }
        System.out.print('\n');
    }
}
