import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import Package.JavaCreature.HuLuWa;
import Package.JavaCreature.GrandFather;
import org.apache.commons.codec.binary.Base64;
import java.lang.reflect.*;

class MyClassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(String classCode) throws ClassNotFoundException{
        byte[] classData = getClassData(classCode);  // 获取类的字节数组
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(classData, 0, classData.length);

        }
    }

    private byte[] getClassData(String classCode){
        return Base64.decodeBase64(classCode);
    }

}


public class MyClassLoaderTest {
    public static void main(String[] args) throws Exception{


            Scanner in = new Scanner(System.in);
            String classCode=in.nextLine();//从终端输入类型字符串
           // String classCode = new String("yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=");

            if(classCode==null)return;
            MyClassLoader myClassLoader = new MyClassLoader();
            Class<?> myClass = myClassLoader.findClass(classCode);

            //直接通过Class对象查看类的方法与域，并打印
            Method [] classMethods=myClass.getDeclaredMethods();
            Field [] classFields=myClass.getDeclaredFields();

            System.out.println(myClass.getName());
            for(Method tempMethod: classMethods){
                System.out.println(tempMethod.toString());
            }

            for( Field tempField: classFields){
               System.out.println(tempField.toString());
             }

            //获取类所有的构造函数并打印
            Constructor<?> []classConstructors = myClass.getDeclaredConstructors();
            for (Constructor<?> constructor : classConstructors) {
                System.out.println(constructor);
            }
            //通过上述程序发现该类仅有一个默认权限的构造函数，参数类型依次为String,int,int，因此这里使用该构造函数创建对象，并打印对象以表示对象的成功创建
            classConstructors[0].setAccessible(true);
            Object myObject=classConstructors[0].newInstance("aaa",5,5);
            System.out.println(myObject.toString());

    }
}
