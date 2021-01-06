public class Choreography implements SortMethod {
    @Override
    public void sort(GrandFather grandFather ,GourdBaby gourdBabies[]){
        for(int i=0;i<6;i++){
            for(int j=0;j<6-i;j++){
                if(gourdBabies[j].compare_order(gourdBabies[j+1])){
                    gourdBabies[j].gourdbabysort(gourdBabies[j+1]);
                }
            }
        }
    }
}
