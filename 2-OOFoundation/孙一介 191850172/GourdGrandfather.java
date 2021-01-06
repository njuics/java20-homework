import java.util.ArrayList;
public class GourdGrandfather {
    private GourdBaby temple;
    public void orchestration(GourdBaby baby[]){
        for(int i=0;i< baby.length-1;i++){
            for(int j=i+1;j< baby.length;j++){
                if(baby[i].getRanking()>baby[j].getRanking()){
                    temple.setName(baby[i].getName());
                    temple.setRanking(baby[i].getRanking());
                    baby[i].setRanking(baby[j].getRanking());
                    baby[i].setName(baby[j].getName());
                    baby[j].setName(temple.getName());
                    baby[j].setRanking(temple.getRanking());
                }
            }
        }
        for(int i=0;i< baby.length;i++){
            System.out.println(baby[i].getName());
        }
    }
}
