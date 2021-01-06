package human;

public class Grandpa {
    public boolean cmp(Hulu a, Hulu b) {
        if(a.getRank() > b.getRank())
            return true;
        else 
            return false;
    }

    public void command(Hulu []hulu, int i, int j) {
        Hulu tmp = hulu[i];
        hulu[i] = hulu[j];
        hulu[j] = tmp;
    }
}