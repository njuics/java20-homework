import java.util.Random;

public class CreatWorld {
   Ground ground_list;
   GrandFather grandfather;
   Random random;
   boolean[] sevenpos;
   CreatWorld()
   {
      ground_list=new Ground();
      grandfather=new GrandFather();
      sevenpos=new boolean[7];
     for(int i=0;i<7;i++)
        sevenpos[i]=false;
      random=new Random();
      World_init();
   }
   void World_init()
   {
      for(int i=0;i<7;i++)
         sevenpos[i]=false;
      for (int i=0;i<7;i++)
      {
         int ran=random.nextInt(7);
         ran=ran%7;
         if(!sevenpos[ran])
         {
            sevenpos[ran]=true;
            ground_list.init(i,COLOR.values()[i],ran,i);
           // one.initial(COLOR.Red,ran,i);
         }
         else
            i--;
      }
   }
   void orchestration()
   {
      grandfather.sotr_child(ground_list);
   }
   void choreography()
   {
     World_init();
     print_list();
     for(int i=0;i<7;i++)
     {
        while(ground_list.brother[i].rank!=ground_list.brother[i].pos)
        {
           ground_list.brother[i].send_patner(ground_list);
        }
     }



   }
   void print_list()
   {
      for(int i=0;i<7;i++)
      {
         int rank_cur=ground_list.brother[i].get_rank();
         switch (rank_cur) {
            case 0:
            System.out.println("老大");break;
            case 1:
               System.out.println("老二");break;
            case 2:
               System.out.println("老三");break;
            case 3:
               System.out.println("老四");break;
            case 4:
               System.out.println("老五");break;
            case 5:
               System.out.println("老六");break;
            case 6:
               System.out.println("老七");break;
         }
      }
   }

}


class Ground{
    CalabashBrothers[] brother ;
   Ground()
   {
      brother =new CalabashBrothers[7];

      CalabashBrothers kid1=new CalabashBrothers();
      brother[0]=kid1;
      CalabashBrothers kid2=new CalabashBrothers();
      brother[1]=kid2;
      CalabashBrothers kid3=new CalabashBrothers();
      brother[2]=kid3;
      CalabashBrothers kid4=new CalabashBrothers();
      brother[3]=kid4;
      CalabashBrothers kid5=new CalabashBrothers();
      brother[4]=kid5;
      CalabashBrothers kid6=new CalabashBrothers();
      brother[5]=kid6;
      CalabashBrothers kid7=new CalabashBrothers();
      brother[6]=kid7;
     /* for(int i=0;i<7;i++)
         System.out.println(brother[i].rank);*/
   }
   CalabashBrothers get_kid(int i)
   {
      return brother[i];
   }
   void init(int i,COLOR colour,int rank,int pos)
   {
   brother[i].initial(colour,rank,pos);
   }

}

class Begin {
      public static void main(String[] args) {
         CreatWorld myworldd=new CreatWorld();
         System.out.println("Before orchestration...");
         myworldd.print_list();
         //System.out.println("hello");
         myworldd.orchestration();
         System.out.println("Finished orchestration sort...");
         myworldd.print_list();
         //World_init();
         System.out.println("Before choreography...");
         //myworldd.print_list();
         //System.out.println("hello");
         myworldd.choreography();
         System.out.println("Finished choreography sort...");
         myworldd.print_list();


      }
   }