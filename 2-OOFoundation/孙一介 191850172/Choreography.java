public class Choreography {
    public void choreography(GourdBaby baby[]){
        for(int i=0;i< baby.length;i++){
            for(int j=0;j< baby.length-i-1;j++){
                if(baby[j].getRanking()>baby[j+1].getRanking()){
                    GourdBaby temple = new GourdBaby(null,0);
                    temple.setRanking(baby[j+1].getRanking());
                    temple.setName(baby[j+1].getName());
                    baby[j+1].setName(baby[j].getName());
                    baby[j+1].setRanking(baby[j].getRanking());
                    baby[j].setRanking(temple.getRanking());
                    baby[j].setName(temple.getName());
                }
            }
        }
        for(int i=0;i<baby.length;i++){
            System.out.println(baby[i].getName());
        }
    }
}
