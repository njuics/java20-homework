package world.sort;
import world.creature.*;

public class Orchestration implements SortMethod{
    @Override
    public void sort(GrandFather gf, Huluwa[] arr){
        gf.sort(arr);
    }
}