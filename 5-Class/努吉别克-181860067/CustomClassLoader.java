import com.sun.deploy.security.ValidationState;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Base64;
import java.lang.reflect.*;

public class CustomClassLoader extends ClassLoader {
    @Override
    public Class findClass(String name) throws ClassNotFoundException{
        try{
            byte[] b =loadClassFromString();
            return defineClass(null,b,0,b.length);}
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return super.findClass(name);
    }
    private byte[] loadClassFromString()
    {
        String base64string="yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=";
        byte[] codeBytes= Base64.getDecoder().decode(base64string);
        return codeBytes;
    }
    public static void main(String args[])
    {
        String name=" ";
        try {
            //加载类
            CustomClassLoader my_class = new CustomClassLoader();
            Class<?> class1 = my_class.loadClass("");
            Method m[]=class1.getDeclaredMethods();
            //打印函数成员
            System.out.println("函数成员:");
            for(int i=0;i<m.length;i++)
            {
                System.out.println(m[i].toString());
                Method m1=m[i];
                System.out.println("name:"+m1.getName());
                System.out.println("DeclaringClass:"+m1.getDeclaringClass());
                Class param[]=m1.getParameterTypes();
                for(int j=0;j<param.length;j++)
                    System.out.println("parameter"+j+" :"+param[j]);
               Class returns=m1.getReturnType();
               System.out.println("return type:"+returns);

            }
            //打印数据成员
            System.out.println("数据成员：");
            Field field_list[]=class1.getDeclaredFields();
            for (int i = 0; i < field_list.length; i++) {
                Field field1 = field_list[i];
                System.out.println("name= " +  field1.getName());
                System.out.println("declaring class = " + field1.getDeclaringClass());
                System.out.println("type = " +  field1.getType());
                System.out.println("-----");
            }
            //打印构造函数信息
            System.out.println("构造函数：");
            Constructor ctorlist[] = class1.getDeclaredConstructors();
            for (int i = 0; i < ctorlist.length; i++) {
                System.out.println("******");
                Constructor ctor1 = ctorlist[i];
                System.out.println("name = " + ctor1.getName());
                System.out.println("declaring class = " + ctor1.getDeclaringClass());
                Class pvec[] = ctor1.getParameterTypes();
                for (int j = 0; j < pvec.length; j++)
                    System.out.println("parameter" + j + ":" + pvec[j]);
                System.out.println("******");
                name=class1.getSimpleName();

            }
            //第二种加载类的方法
            System.out.println("类名："+name);
            System.out.println("类加载：");
            Class new_one=Class.forName(name,false,my_class);
            System.out.println("类加载成功：");

            //获取到参数列表，根据参数个数及相关信息获取到构造器
            Class pvec[] = ctorlist[0].getParameterTypes();
            int para_s= pvec.length;
            Class partypes[] = new Class[para_s];
            for (int j = 0; j < pvec.length; j++)
            {
                String name_now;
                name_now=pvec[j].getName();
                if(pvec[j].getName()=="int")
                {
                  partypes[j]=int.class;
                }
                else if(pvec[j].getName()=="java.lang.String")
                {
                    partypes[j]=String.class;
                }
            }
            Constructor<?> ct = class1.getDeclaredConstructor(partypes);
            ct.setAccessible(true);
            //构造参数列表
            Object arglist[] = new Object[para_s];
            for(int k=0;k<para_s;k++)
            {
                if(partypes[k]==int.class)
                {
                   arglist[k]=new Integer(0);
                }
                else
                {
                    arglist[k]=new String(" ");
                }
            }
            //创建实例
            System.out.println("创建实例:");
            Object retobj = ct.newInstance(arglist);
            System.out.println("done.");

        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Failed0.");
        }
        catch (IllegalAccessException e) {
            System.out.println("Failed1.");
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.out.println("Failed2.");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println("Failed3.");
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            System.out.println("Failed4.");
            e.printStackTrace();
        }

    }
}
//参考资料：https://www.oracle.com/technical-resources/articles/java/javareflection.html
