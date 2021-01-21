import java.util.*;

public class MySort{
    MySort(){
    }

    public <T extends Creature> void printInfo(List<T> list){
        for(int i=0; i<list.size(); ++i){
            System.out.println(list.get(i).getName());
        } 
    }

    public <T extends Creature> void outOfOrder(List<T> list){
        Collections.shuffle(list);
        System.out.println("---Result:");
        printInfo(list);
    }

    public <T extends Creature> void positiveOrder(List<T> list){
        Collections.sort(list);
        System.out.println("---Result:");
        printInfo(list);
    }

    public <T extends Creature> void negativeOrder(List<T> list){
        Collections.sort(list,new Comparator<T>() {
            @Override
            public int compare(T h1, T h2) {
                if (h1.getName().compareTo(h2.getName())<0)
                    return 1;
                else if (h1.getName().compareTo(h2.getName())==0)
                    return 0;
                else
                    return -1;
            }
        });
        System.out.println("---Result:");
        printInfo(list);
    }

    public <T extends Creature> void genderSort(List<T> list, boolean flag){   // flag: 0 for positive, 1 for negative
        List<T> male= new ArrayList<>();
        List<T> female = new ArrayList<>();
        for(int i=0;i<list.size();++i){
            if(list.get(i).getGender()==true){
                male.add(list.get(i));
            }
            else{
                female.add(list.get(i));
            }
        }
        if(flag == false){
            Collections.sort(male);
            Collections.sort(female);
        }
        else{
            Collections.sort(male,new Comparator<T>() {
                @Override
                public int compare(T h1, T h2) {
                    if (h1.getName().compareTo(h2.getName())<0)
                        return 1;
                    else if (h1.getName().compareTo(h2.getName())==0)
                        return 0;
                    else
                        return -1;
                }
            });
            Collections.sort(female,new Comparator<T>() {
                @Override
                public int compare(T h1, T h2) {
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
        for(int i=0; i<male.size(); ++i){
            System.out.println(male.get(i).getName());
        } 
        System.out.println("->female:");
        for(int i=0; i<female.size(); ++i){
            System.out.println(female.get(i).getName());
        } 

        list.clear();
        list.addAll(male);
        list.addAll(female);
    }

}
