public class Position<T extends Creature> {
    public T living;
    private Class<T> kind;
    public Position(Class<T> kind){ this.kind = kind;  init(); }
    public void init(){
        try{
            this.living = kind.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
   void print_info()
   {
       living.print_name();
   }
   public T get()
   {
       return living;
   }

    public int compareTo(Position b)
    {
        return living.compareTo(b.living);
    }
}
//课件RTTI代码