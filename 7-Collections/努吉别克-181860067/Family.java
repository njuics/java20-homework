import java.util.*;

public class Family implements Iterable<Calabash>{
    private Set<String> exist_name=new LinkedHashSet<>();
    public static ArrayList<Calabash> family=new ArrayList<>();
    private int member_count;
  Family()
  {
      member_count=0;

  }
  void add_member()
  {
        String name=get_random_name();
        boolean if_exist= exist_name.add(name);
        while(if_exist==false) {
            if_exist= exist_name.add(name);
            name=get_random_name();
        }
        String gender=get_gender();
        Calabash new_one=new Calabash(name,gender);
        family.add(new_one);
        member_count++;
        System.out.print("member:"+member_count+"\n");
        System.out.print("姓名："+name+"    性别："+gender+"   ");


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
  public static void display_well(Iterator<Calabash> it)
  {
      System.out.println();
      Collections.sort(family);
      System.out.println("正序：");
        while(it.hasNext())
        {
            Calabash p=it.next();
            System.out.print("姓名："+p.get_name()+" 性别："+p.get_gender()+"  ");
        }
        System.out.println();

  }

  public static void display_comparator(Iterator<Calabash> it)
  {
      System.out.println();
      CalaBash_Comparetor com=new CalaBash_Comparetor();
      Collections.sort(family,com);
      System.out.println("逆序：(comparator)");
      while(it.hasNext())
      {
          Calabash p=it.next();
          System.out.print("姓名："+p.get_name()+":"+p.get_gender()+" ");
      }
      System.out.println();
  }

  public  static void display_reverse(Family my_family)
  {
      System.out.println();
      Collections.sort(family);
      System.out.println("逆序：");
      /*while(it.hasNext())
      {
          Calabash p=it.next();
          System.out.print(p.get_name()+":"+p.get_gender());
      }*/
      for(Calabash s : my_family.reversed())
          System.out.print("姓名："+s.get_name()+":"+s.get_gender()+"  ");
      System.out.println();
  }

    public  static void display_shuffle(Family my_family)
    {
        System.out.println();
        Collections.sort(family);
        System.out.println("乱序：");
        /*while(it.hasNext())
        {
            Calabash p=it.next();
            System.out.print(p.get_name()+":"+p.get_gender());
        }*/
        for(Calabash s : my_family.randomized())
            System.out.print("姓名："+s.get_name()+":"+s.get_gender()+"  ");
        System.out.println();
    }
    public Iterator<Calabash> iterator()
    {
        return new Iterator<Calabash>()
        {
            private int  index=0;
            @Override
            public boolean hasNext()
            {
                return  index<family.size();
            }
            @Override
            public Calabash next()
            {
                return family.get(index++);
            }
            @Override
            public void remove()
            {
                //throw new UnsupportedOperationException();
            }
        };
    }

    public Iterable<Calabash> reversed() {
        return new Iterable<Calabash>() {
            public Iterator<Calabash> iterator() {
                return new Iterator<Calabash>() {
                    int current = family.size()- 1;
                    public boolean hasNext() {
                        return current > -1;
                    }
                    public Calabash next() {
                        return family.get(current--);
                    }
                    public void remove() { // Not implemented
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
    public Iterable<Calabash> randomized() {
        return new Iterable<Calabash>() {
            public Iterator<Calabash> iterator() {
                List<Calabash> shuffled =
                        new ArrayList<Calabash>(family);
                Collections.shuffle(shuffled, new Random(47));
                return shuffled.iterator();
            }
        };
    }

    public void team(Iterator<Calabash> it)
    {
        ArrayList<Calabash> team_list_boy=new ArrayList<>();
        ArrayList<Calabash> team_list_girl=new ArrayList<>();
        CalaBash_Comparetor_gender com=new CalaBash_Comparetor_gender();
        Collections.sort(family,com);
        System.out.println();
        System.out.println("正序：");
        while(it.hasNext())
        {
            Calabash p=it.next();
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
        for(Calabash s:team_list_boy)
            System.out.print(s.get_name()+"    ");

        System.out.print("\n女生队：");
        for(Calabash s:team_list_girl)
            System.out.print(s.get_name()+"    ");
        System.out.println();

       System.out.print("字典序排序：\n");
        System.out.print("男生队：");
        Collections.sort(team_list_boy);
        Collections.sort(team_list_girl);
        for(Calabash s:team_list_boy)
            System.out.print(s.get_name()+"    ");

        System.out.print("\n女生队：");
        for(Calabash s:team_list_girl)
            System.out.print(s.get_name()+"    ");

        System.out.print("\n逆序排序：\n");
        Collections.sort(team_list_boy);
        Collections.sort(team_list_girl);
        Collections.reverse(team_list_boy);
        Collections.reverse(team_list_girl);
        System.out.print("男生队：");
        for(Calabash s:team_list_boy)
            System.out.print(s.get_name()+"    ");

        System.out.print("\n女生队：");
        for(Calabash s:team_list_girl)
            System.out.print(s.get_name()+"    ");

        System.out.print("\n乱序排序：\n");
        Collections.sort(team_list_boy);
        Collections.sort(team_list_girl);
        Collections.shuffle(team_list_boy);
        Collections.shuffle(team_list_girl);
        System.out.print("男生队：");
        for(Calabash s:team_list_boy)
            System.out.print(s.get_name()+"    ");

        System.out.print("\n女生队：");
        for(Calabash s:team_list_girl)
            System.out.print(s.get_name()+"    ");

    }

}
class CalaBash_Comparetor implements Comparator<Calabash>
{

    @Override
    public int compare(Calabash o1, Calabash o2) {
        String name1=o1.get_name();
        String name2=o2.get_name();
        int result=name1.compareTo(name2);
        return -result;
    }
}

class CalaBash_Comparetor_gender implements Comparator<Calabash>
{

    @Override
    public int compare(Calabash o1, Calabash o2) {
        String name1=o1.get_gender();
        String name2=o2.get_gender();
        int result=name1.compareTo(name2);
        return result;
    }
}
//按名字的字典序进行排序正向、反序、乱序，打印
//分成两个队伍、排序、打印
