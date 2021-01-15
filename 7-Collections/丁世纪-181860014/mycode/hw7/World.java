package mycode.hw7;

import java.util.*;

//import org.w3c.dom.UserDataHandler;


public class World {
    public static int HULU_NUM=7;
    public static void main(String[] args) throws Exception {
      

        World w=new World();

        w.test();
    }

    void test()
    {
        this.Shuffle();
        System.out.println("Orchestration...");
        this.Orchestration();
        this.Self_intro();

        this.Shuffle();      
        System.out.println("Choreography...");
        this.Choreography();
        this.Self_intro();
        System.out.println("Sorted by themselves.");

        System.out.println("total population is "+this.gp.population());

       
    }
/*
    void test_attack()
    {
        hulu[0].Attack();
        hulu[0].Learn("亢龙有悔", "飞龙在天");
        hulu[0].Attack();
        hulu[0].Ultra();
        hulu[1].Learn("见龙在田", "潜龙勿用");
        hulu[0].Ultra(hulu[1]);
    }

    */
    Grandpa gp;
    List<HuluBrother> hulu =new ArrayList<>();
    Set<String> usednames=new HashSet<>();
    String[] names={"大娃","二娃","三娃","四娃","五娃","六娃","七娃"};
    String[] boynames=("Aaron Alexander Andrew Anthony Asher Benjamin Caleb Charles Christopher Connor Daniel David Elijah Ethan Ezra Grayson Harper Henry Hudson Isaac Isaiah Jack Jackson Jacob Jaxon Jeremiah John Jonathan Joseph Joshua Josiah Landon Leo Levi Liam Lincoln Lucas Luke Mateo Matthew Nathan Noah Oliver Owen Samuel Sebastian Theodore Thomas William Wyatt").split(" ");
    String[] girlnames=("Aaliyah Abigail Amelia Anna Aria Ariana Audrey Aurora Bella Camila Caroline Charlotte Chloe Eleanor Elena Elizabeth Ella Ellie Emilia Emily Emma Grace Hannah Isabella Layla Leah Lillian Lily Lucy Luna Maya Mia Mila Naomi Natalie Nora Nova Olivia Penelope Samantha Sarah Savannah Scarlett Sofia Sophia Stella Victoria Violet Willow Zoey").split(" ");
    World()
    {
      //  InitWithOriginNames();
        InitWithRandomNames();
    }
    void InitWithRandomNames()
    {
        Random ran=new Random();
        
        gp=new Grandpa(HULU_NUM);
        //hulu=new HuluBrother[HULU_NUM];5
      
        for(int i=0;i<HULU_NUM;i++)
        {
            Gender g=Gender.unknown;
            String str;
            if(ran.nextBoolean()==false)
            {
                g = Gender.male;
                if(usednames.size()>=boynames.length)
                {
                    System.exit(12345);
                }
                while(true)
                {
                    str=boynames[ran.nextInt(boynames.length)];
                    if(usednames.contains(str)==false)
                    {
                        usednames.add(str);
                        break;
                    }
                }
            }
            else{
                g = Gender.female;
                if(usednames.size()>=boynames.length)
                {
                    System.exit(12345);
                }
                while(true)
                {
                    str=boynames[ran.nextInt(boynames.length)];
                    if(usednames.contains(str)==false)
                    {
                        usednames.add(str);
                        break;
                    }
                }
            }
 //           System.out.println(str+" "+i+" "+g.toString());
          
            HuluBrother h=new HuluBrother(str, i,g);
            h.intro();
            hulu.add(h);
            
            
        }
        System.out.println("new boys created");
        for(int i=0;i<HULU_NUM;i++)
        {
            hulu.get(i).intro();
        }
    }
  /*  void InitWithOriginNames()
    {
        
        gp=new Grandpa(HULU_NUM);
        hulu=new HuluBrother[HULU_NUM];
        for(int i=0;i<HULU_NUM;i++)
        {
            hulu[i]=new HuluBrother(names[i],i);
        }
    }
    */
    void Self_intro()
    {
        for(int i=0;i<HULU_NUM;i++)
        {
            hulu.get(i).intro();
        }
    }

    void Swap2boy(int a,int b)
    {
        if (a==b) return;
        HuluBrother temp= hulu.get(a);
        hulu.set(a,hulu.get(b));
        hulu.set(b,temp);
    }

    void Shuffle()
    {
        gp.Shuffle(this);
    }

    void Orchestration()
    {
        gp.Sort(this);
        
        gp.Speaksth("Sorted");
    }

    void Choreography()
    {
        //sort by themselves
        for(int i=0;i<HULU_NUM;i++)
        {
           hulu.get(i).Self_sort(this, i);
        }
        this.Self_intro();
        System.out.println("******************sort by alphabet******************");
        //字典正序
        for(int i=0;i<HULU_NUM;i++)
        {
           hulu.get(i).Self_sort_alphabet_new(this, i);
        }
        
    }
}
