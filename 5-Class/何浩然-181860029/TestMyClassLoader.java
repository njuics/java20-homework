
import java.lang.reflect.*;
import java.util.Scanner;
import java.util.Arrays;
public class TestMyClassLoader {
    public static  void main(final String[] args) throws Exception {
        String context=null;
        Scanner input = new Scanner(System.in);
        context = input.next();//输入base64编码的字符串
        MyClassLoader m=new MyClassLoader();
        Class<?> c=m.findClass(null,context);

        if (c!=null){
            //获取类名
            System.out.println(c.getName());
            Constructor<?> cons=c.getDeclaredConstructor(String.class,int.class,int.class);//Monster.<init>(java.lang.String, int, int)
            cons.setAccessible(true);
            Object obj = cons.newInstance("张三", 20,20); // 为构造方法传递参数
            System.out.println(obj);
            //通过反射机制获得成员和方法
            Field[] fi = obj.getClass().getDeclaredFields();
            Method[] meth = obj.getClass().getDeclaredMethods();
            System.out.println(Arrays.toString(fi));
            System.out.println(Arrays.toString(meth));

          }

        }

    }
