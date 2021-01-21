package character;
public class Grandpa{
    public boolean compareSmall(Huluwa x,Huluwa y){
        int x_index=x.answerIndex();
        int y_index=y.answerIndex();
        if(x_index<y_index){
            return true;
        }
        else{
            return false;
        }
    }
    public void swap(Huluwa x,Huluwa y){
        int x_index=x.answerIndex();
        int y_index=y.answerIndex();
        x.setIndex(y_index);
        y.setIndex(x_index);

    }
}