public class GrandFather extends Creature{
    static {
        System.out.println("爷爷对象创建完成");
    }
    public void sort(GourdBaby[] gourdBabies){
        for(int i=0;i<6;i++){
            for(int j=0;j<6-i;j++){
                if(gourdBabies[j].get_order()>gourdBabies[j+1].get_order()){
                    GourdBaby temple = gourdBabies[j];
                    gourdBabies[j] = gourdBabies[j+1];
                    gourdBabies[j+1] = temple;
                }
            }
        }
    }
}
