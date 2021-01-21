import java.lang.reflect.*;

public class Homework5{
    public static void main(String[] args) throws Exception{
        MyClassLoader mCls = new MyClassLoader();
        Class<?> c = mCls.findClass(null, "base/Input");
        try{
            System.out.println("Class Name: " + c.getName());
            System.out.println();

            Constructor<?> constructors = c.getDeclaredConstructor(java.lang.String.class, int.class, int.class);
            constructors.setAccessible(true);
            Object obj = constructors.newInstance("Little Monster", 8, 1);

            //print Instance of Instance obj
            System.out.println("Instance: " + obj.toString());
            System.out.println("  name: " + c.getDeclaredField("name").get(obj));
            System.out.println("  health: " + c.getDeclaredField("health").get(obj));
            System.out.println("  damage: " + c.getDeclaredField("damage").get(obj));
            System.out.println();

            //print Constructors of Instance obj
            Constructor<?>[] constructors_ins = obj.getClass().getDeclaredConstructors();
            System.out.println("Constructors:");
            for (Constructor<?> con : constructors_ins) {
                System.out.println("  " + con);
            }
            System.out.println();
            
            //print Fields of Instance obj
            Field[] fields = obj.getClass().getDeclaredFields();
            System.out.println("Instance Fields:");
            for (Field field : fields) {
                System.out.println("  " + field);
            }
            System.out.println();

            //print Methods of Instance obj
            Method[] methods = obj.getClass().getDeclaredMethods();
            System.out.println("Instance Methods:");
            for (Method method : methods) {
                System.out.println("  " + method);
            }
            System.out.println();
        }
        catch(Exception e){
            //Do something here
            throw(e);
        }

        return;
    }
}