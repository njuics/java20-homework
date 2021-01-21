public class CalabashBrothersSort extends GrandFatherSort{
    public void Sort(CalabashBrothers[] brothers, int l, int r){

        for(int i = l; i < r; i++){
            for(int j = l; j < r - i; j++){
                if(brothers[j].getNumber() > brothers[j + 1].getNumber()){
                    CalabashBrothers.changePlace(brothers[j], brothers[j + 1]);
                    //乖巧的葫芦娃此处交换了一下位置
                }
            }
        }
    }
}
