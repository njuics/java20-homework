import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Hulu implements Comparable<Hulu> {
    private String name;
    private boolean gender;
    static public int sortway;   //控制排序方式
    Hulu(){
        //利用org.apache.commons.lang包下有一个RandomStringUtils类，随机生成一个长度为5的字符串作为葫芦娃的名字
        name = RandomStringUtils.randomAlphabetic(5);
        //随机产生性别
        gender = new Random().nextBoolean();
    }
    Hulu(String name1,boolean gender1){
        name = name1;
        gender = gender1;
    }
    public String getName(){
        return name;
    }
    public boolean getGender(){
        return gender;
    }

    @Override
    public int compareTo(Hulu o) {
        if(sortway==0||sortway==2)
            return name.compareTo(o.getName());
        else if(sortway==1)
            return -name.compareTo(o.getName());
        else
        {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
    }
}
