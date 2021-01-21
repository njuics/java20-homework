package world;
import java.util.Random;

import model.Calabash;
public class World {
    private static Random rand = new Random();
    public void run(){}
    public void randomShuffle(Calabash[] calabashs){
        int shuffle_times = 10 + rand.nextInt(20);
        int n = calabashs.length;
        for(int i=0; i<shuffle_times; ++i){
            int a = rand.nextInt(n);
            int b = rand.nextInt(n);
            if(a == b)continue;
            Calabash tmp = calabashs[a];
            calabashs[a] = calabashs[b];
            calabashs[b] = tmp;
        }
    }
}
