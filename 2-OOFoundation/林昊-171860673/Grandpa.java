public class Grandpa {
    SingleHuLuWa[] huLuWaArray;
    Grandpa(ManageHuLuWa manageHuLuWa){
        huLuWaArray = manageHuLuWa.getHuLuWaInfo();
    }

    public void grandpaSort(){
        Sort.grandpaSort(huLuWaArray);
    }
}
