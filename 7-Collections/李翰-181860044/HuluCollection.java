import java.util.*;

public class HuluCollection implements Iterable<Hulu>{
    private List<Hulu> huluList;
    private int num;

    HuluCollection(){
        Random random = new Random();
        num = random.nextInt(10)+15;
        huluList = new ArrayList<>();
        for(int i=0; i<num; ++i){
            huluList.add(new Hulu());
        }
    }

    public void printInfo(){
        for(int i=0; i<num; ++i){
            System.out.println(huluList.get(i).getName());
        } 
    }

    public Iterator<Hulu> iterator() {
        return new Iterator<Hulu>() {
            private int index = 0;
            public boolean hasNext() {return index < num-1;}
            public Hulu next() { return huluList.get(index++);    }
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }

    public void outOfOrder(){
        Collections.shuffle(huluList);
        System.out.println("---Result:");
        printInfo();
    }

    public void positiveOrder(){
        Collections.sort(huluList);
        System.out.println("---Result:");
        printInfo();
    }

    public void negativeOrder(){
        Collections.sort(huluList,new Comparator<Hulu>() {
            @Override
            public int compare(Hulu h1, Hulu h2) {
                if (h1.getName().compareTo(h2.getName())<0)
                    return 1;
                else if (h1.getName().compareTo(h2.getName())==0)
                    return 0;
                else
                    return -1;
            }
        });
        System.out.println("---Result:");
        printInfo();
    }

    public void genderSort(boolean flag){   // flag: 0 for positive, 1 for negative
        List<Hulu> maleHulu = new ArrayList<>();
        List<Hulu> femaleHulu = new ArrayList<>();
        for(int i=0;i<num;++i){
            if(huluList.get(i).getGender()==true){
                maleHulu.add(huluList.get(i));
            }
            else{
                femaleHulu.add(huluList.get(i));
            }
        }
        if(flag == false){
            Collections.sort(maleHulu);
            Collections.sort(femaleHulu);
        }
        else{
            Collections.sort(maleHulu,new Comparator<Hulu>() {
                @Override
                public int compare(Hulu h1, Hulu h2) {
                    if (h1.getName().compareTo(h2.getName())<0)
                        return 1;
                    else if (h1.getName().compareTo(h2.getName())==0)
                        return 0;
                    else
                        return -1;
                }
            });
            Collections.sort(femaleHulu,new Comparator<Hulu>() {
                @Override
                public int compare(Hulu h1, Hulu h2) {
                    if (h1.getName().compareTo(h2.getName())<0)
                        return 1;
                    else if (h1.getName().compareTo(h2.getName())==0)
                        return 0;
                    else
                        return -1;
                }
            });
        }
        System.out.println("---Result:");
        System.out.println("->male:");
        for(int i=0; i<maleHulu.size(); ++i){
            System.out.println(maleHulu.get(i).getName());
        } 
        System.out.println("->female:");
        for(int i=0; i<femaleHulu.size(); ++i){
            System.out.println(femaleHulu.get(i).getName());
        } 
    }

}
