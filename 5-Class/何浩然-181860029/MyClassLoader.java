import java.util.Base64;

public class MyClassLoader extends ClassLoader{
     String context;
     MyClassLoader(){
         context=null;
     }
    public Class<?> findClass(String name,String c) throws ClassNotFoundException {
        context=c;
        byte[] b = Base64.getDecoder().decode(context);
        //System.out.println(Arrays.toString(b));
        if (b == null) {
            return super.findClass(name);
        } else {
            //defineClass方法将字节码转化为类
            return defineClass(name, b, 0, b.length);
        }

    }


}
