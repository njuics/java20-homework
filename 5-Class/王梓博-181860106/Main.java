/*
 * @Author: zb-nju
 * @Date: 2020-10-18 11:38:15
 * @LastEditors: zb-nju
 * @LastEditTime: 2020-10-18 16:06:45
 */
import java.lang.reflect.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        CustomClassLoader loader = new CustomClassLoader();
        try{
            Class cls = loader.findClass("class.txt");
            String name = cls.getName();
            System.out.println("name:"+name);

            Method[] mList = cls.getDeclaredMethods();
            for(int i=0;i<mList.length;i++)
                System.out.println("method #"+i+": "+mList[i].toString());

            Constructor[] ctList = cls.getDeclaredConstructors();
            for(int i=0;i<ctList.length;i++)
                System.out.println("constructor #"+i+": "+ctList[i].toString());

            Field[] fList = cls.getDeclaredFields();
            for(int i=0;i<fList.length;i++)
                System.out.println("field #"+i+": "+fList[i].toString());

            try{
                Class[] paratypes = new Class[3];
                paratypes[0] = java.lang.String.class;
                paratypes[1] = int.class;
                paratypes[2] = int.class;
    
                Constructor ct = cls.getDeclaredConstructor(paratypes);
                ct.setAccessible(true);
                Object[] arglist = new Object[3];
                arglist[0] = new String("Godzilla");
                arglist[1] = new Integer("10000");
                arglist[2] = new Integer("10000");

                Object obj = ct.newInstance(arglist);
                System.out.println("create a new instance"+obj);
            }catch (Exception e) {
                e.printStackTrace();
            }

        }catch (ClassNotFoundException I){
            System.out.println("class not found exception");
        }
    }
}
