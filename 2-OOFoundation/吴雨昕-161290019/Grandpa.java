public class Grandpa {
    public void orient(BoyQueue boyQueue){
        for(int i=1;i<=7;i++){
            int pos = boyQueue.findBoy(i);
            boyQueue.queue[i-1].swap(boyQueue.queue[pos]);
        }
    }
}