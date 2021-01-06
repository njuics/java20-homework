import java.util.*;

public class MyGourdBabyContainer implements Iterable<GourdBaby>, Comparator<GourdBaby> {
    private List<GourdBaby> gourdBabyList;
    private List<GourdBaby> maleGourdBabyList;
    private List<GourdBaby> femaleGourdBabyList;
    public  MyGourdBabyContainer() {
        this.gourdBabyList = new ArrayList<GourdBaby>();
        this.maleGourdBabyList = new ArrayList<GourdBaby>();
        this.femaleGourdBabyList = new ArrayList<GourdBaby>();
    }
    public void add(GourdBaby gourdBaby) {
        gourdBabyList.add(gourdBaby);
    }

    public void sort() {
        Collections.sort(gourdBabyList,this::compare);
    }
    public Iterator<GourdBaby> iterator() {
        return new Iterator<GourdBaby>() {
            int ptr = 0;
            @Override
            public boolean hasNext() {
                return (ptr < gourdBabyList.size());
            }

            @Override
            public GourdBaby next() {
                return gourdBabyList.get(ptr++);
            }
        };
    }
    public Iterator<GourdBaby> maleiterator() {
        for(GourdBaby gourdBaby : gourdBabyList) {
            if(gourdBaby.getGender()) {
                maleGourdBabyList.add(gourdBaby);
            }
        }
        return new Iterator<GourdBaby>() {
            int ptr = 0;
            @Override
            public boolean hasNext() {
                return ptr < maleGourdBabyList.size();
            }

            @Override
            public GourdBaby next() {
                return maleGourdBabyList.get(ptr++);
            }
        };
    }

    public Iterator<GourdBaby> femaleiterator() {
        for(GourdBaby gourdBaby : gourdBabyList) {
            if(!gourdBaby.getGender()) {
                femaleGourdBabyList.add(gourdBaby);
            }
        }
        return new Iterator<GourdBaby>() {
            int ptr = 0;
            @Override
            public boolean hasNext() {
                return ptr < femaleGourdBabyList.size();
            }

            @Override
            public GourdBaby next() {
                return femaleGourdBabyList.get(ptr++);
            }
        };
    }

    @Override
    public int compare(GourdBaby o1, GourdBaby o2) {
        String n1 = o1.getName();
        String n2 = o2.getName();
        return n1.compareTo(n2);
    }
}
