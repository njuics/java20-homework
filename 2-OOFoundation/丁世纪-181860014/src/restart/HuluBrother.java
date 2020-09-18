//


public class HuluBrother {
   String name;
   int rank;//  老大rank=0
   

   HuluBrother()
   {
       name="ungiven";
       rank=-1;
   }
   HuluBrother(String s,int i)
   {
        name=s;
        rank=i;
   }

   void Init(String s,int i)
   {
        name=s;
        rank=i;
   }

   void Self_intro()
   {
       System.out.println("My name is "+name);
      // System.out.println("The "+rank+"th boy");    //nevermind 1th
   }

 


}
