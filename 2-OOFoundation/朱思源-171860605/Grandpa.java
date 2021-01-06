public class Grandpa {

    public void sort(Queue que){
        for(int j=que.len-1;j>0;j--){
            for(int i=0;i<j;i++){
                if(que.array[i].getRank()>que.array[i+1].getRank()){
                    changePos(que.array[i],que.array[i+1]);
                }
            }
        }
    }

    public void changePos(Boy b1, Boy b2){
        b1.changePos(b2);
    }
}
