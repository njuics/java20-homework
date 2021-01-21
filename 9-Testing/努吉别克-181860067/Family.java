import java.util.*;

public class Family <T extends Creature >implements Iterable<T>{
    GrandFather grandfather=new GrandFather();
    private static  Set<String> exist_name=new LinkedHashSet<>();
    public   ArrayList<T> family;
    public ArrayList<T> team_list_boy=new ArrayList<>();
    public ArrayList<T> team_list_girl=new ArrayList<>();
    private int member_count;
    public T new_one;
  Family()
  {
      family=new ArrayList<T>();
      member_count=0;

  }
  void add_member(Class<T> kind)
  {
        String name=get_random_name();
        boolean if_exist= exist_name.add(name);
        while(if_exist==false) {
            if_exist= exist_name.add(name);
            name=get_random_name();
        }
        String gender=get_gender();
      try{
          new_one=kind.newInstance();
      }catch (Exception e) {
          e.printStackTrace();
      }
        new_one.set_name(name);
        new_one.set_gender(gender);
      family.add(new_one);
       member_count++;
        System.out.print("member:"+member_count+"\n");
        System.out.print("姓名："+name+"    性别："+gender+"   ");
  }
  void add_member(Class<T> kind,String name,String gender)
  {
      new_one.set_name(name);
      new_one.set_gender(gender);
      family.add(new_one);
      member_count++;
  }
  String get_random_name()
  {
      String str="abcdefghijklmnopqrstuvwxyz";
      Random random=new Random();
      long time_now=System.currentTimeMillis();
      Random ran_num=new Random(time_now);
      String name_buffer="";
      int length_name=ran_num.nextInt(10)+1;
      for(int i=0;i<length_name;i++)
      {
          int index=ran_num.nextInt(26);
          name_buffer=name_buffer+str.charAt(index);
      }
    return name_buffer;
  }
  String girl_list_gender(int i)
  {
      T p=team_list_girl.get(i);
      return p.get_gender();
  }
  String boy_list_gender(int i)
    {
        T p=team_list_boy.get(i);
        return p.get_gender();
    }
  String get_gender()
  {
      Random random=new Random();
      long time_now=System.currentTimeMillis();
      Random ran_num=new Random(time_now);
      int gender=ran_num.nextInt(1000);
      if(gender%3==1)
          return "男";
      else
          return "女";
  }
  public  void display_well(Iterator<T> it)
  {
      System.out.println();
      CalaBash_Comparetor_normal com=new CalaBash_Comparetor_normal();
      family.sort(com);
      //Collections.sort(family);
      System.out.println("正序：");
        while(it.hasNext())
        {
            T p=it.next();
            System.out.print("姓名："+p.get_name()+" 性别："+p.get_gender()+"  ");
        }
        System.out.println();

  }

  public  void display_comparator(Iterator<T> it)
  {
      System.out.println();
      CalaBash_Comparetor com=new CalaBash_Comparetor();
      Collections.sort(family,com);
      System.out.println("逆序：(comparator)");
      while(it.hasNext())
      {
          T p=it.next();
          System.out.print("姓名："+p.get_name()+":"+p.get_gender()+" ");
      }
      System.out.println();
  }

  public   void display_reverse(Family<T> my_family)
  {
      System.out.println();
      CalaBash_Comparetor_normal com=new CalaBash_Comparetor_normal();
      Collections.sort(family,com);
      System.out.println("逆序：");
      /*while(it.hasNext())
      {
          Calabash p=it.next();
          System.out.print(p.get_name()+":"+p.get_gender());
      }*/
      for(T s : my_family.reversed())
          System.out.print("姓名："+s.get_name()+":"+s.get_gender()+"  ");
      System.out.println();
  }

  public   void display_shuffle(Family<T> my_family)
    {
        System.out.println();
        CalaBash_Comparetor com=new CalaBash_Comparetor();
        Collections.sort(family,com);
        System.out.println("乱序：");
        /*while(it.hasNext())
        {
            Calabash p=it.next();
            System.out.print(p.get_name()+":"+p.get_gender());
        }*/
        for(T s : my_family.randomized())
            System.out.print("姓名："+s.get_name()+":"+s.get_gender()+"  ");
        System.out.println();
    }

    public void clear_family()
    {
        exist_name.clear();
        family.clear();
        member_count=0;
    }
    public Iterator<T> iterator()
    {
        return new Iterator<T>()
        {
            private int  index=0;
            @Override
            public boolean hasNext()
            {
                return  index<family.size();
            }
            @Override
            public T next()
            {
                return family.get(index++);
            }
            @Override
            public void remove()
            {
                //throw new UnsupportedOperationException();
            }
        };
       // return family.iterator();
    }

    public Iterable<T> reversed() {
        return new Iterable<T>() {
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = family.size()- 1;
                    public boolean hasNext() {
                        return current > -1;
                    }
                    public T next() {
                        return family.get(current--);
                    }
                    public void remove() { // Not implemented
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
    public Iterable<T> randomized() {
        return new Iterable<T>() {
            public Iterator<T> iterator() {
                List<T> shuffled =
                        new ArrayList<T>(family);
                Collections.shuffle(shuffled, new Random(47));
                return shuffled.iterator();
            }
        };
    }


    public void team(Iterator<T> it)
    {
        //ArrayList<T> team_list_boy=new ArrayList<>();
        //ArrayList<T> team_list_girl=new ArrayList<>();
        CalaBash_Comparetor_gender com=new CalaBash_Comparetor_gender();
        Collections.sort(family,com);
        System.out.println();
        System.out.println("正序：");
        while(it.hasNext())
        {
            T p=it.next();
            if(p.get_gender()=="男")
            {
                team_list_boy.add(p);
            }
            else
            {
                team_list_girl.add(p);
            }
        }
        System.out.print("男生队：");
        for( T s:team_list_boy)
            System.out.print(s.get_name()+"    ");

        System.out.print("\n女生队：");
        for( T s:team_list_girl)
            System.out.print(s.get_name()+"    ");
        System.out.println();

       System.out.print("字典序排序：\n");
        System.out.print("男生队：");
        Collections.sort(team_list_boy,com);
        Collections.sort(team_list_girl,com);
        for( T s:team_list_boy)
            System.out.print(s.get_name()+"    ");

        System.out.print("\n女生队：");
        for( T s:team_list_girl)
            System.out.print(s.get_name()+"    ");

        System.out.print("\n逆序排序：\n");
        Collections.sort(team_list_boy,com);
        Collections.sort(team_list_girl,com);
        Collections.reverse(team_list_boy);
        Collections.reverse(team_list_girl);
        System.out.print("男生队：");
        for( T s:team_list_boy)
            System.out.print(s.get_name()+"    ");

        System.out.print("\n女生队：");
        for( T s:team_list_girl)
            System.out.print(s.get_name()+"    ");

        System.out.print("\n乱序排序：\n");
        Collections.sort(team_list_boy,com);
        Collections.sort(team_list_girl,com);
        Collections.shuffle(team_list_boy);
        Collections.shuffle(team_list_girl);
        System.out.print("男生队：");
        for( T s:team_list_boy)
            System.out.print(s.get_name()+"    ");

        System.out.print("\n女生队：");
        for( T s:team_list_girl)
            System.out.print(s.get_name()+"    ");

    }

}
class CalaBash_Comparetor implements Comparator<Creature>
{

    @Override
    public int compare(Creature o1, Creature o2) {
        String name1=o1.get_name();
        String name2=o2.get_name();
        int result=name1.compareTo(name2);
        return -result;
    }
}

class CalaBash_Comparetor_normal implements Comparator<Creature>
{

    @Override
    public int compare(Creature o1, Creature o2) {
        String name1=o1.get_name();
        String name2=o2.get_name();
        int result=name1.compareTo(name2);
        return result;
    }
}


class CalaBash_Comparetor_gender implements Comparator<Creature>
{

    @Override
    public int compare(Creature o1, Creature o2) {
        String name1=o1.get_gender();
        String name2=o2.get_gender();
        int result=name1.compareTo(name2);
        return result;
    }
}
//按名字的字典序进行排序正向、反序、乱序，打印
//分成两个队伍、排序、打印
