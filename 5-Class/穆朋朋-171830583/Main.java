// 穆朋朋 171830583
import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) {
        String s="yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=";
        
        CustomClassLoader ccl = new CustomClassLoader(s);
        try {
            Class<?> objClass = ccl.findClass(null);    // 调用方法从字节码获得类对象objClass，类名未知则参数为null;
            
            Field[] f=objClass.getDeclaredFields(); // 属性
            Method[] m=objClass.getDeclaredMethods();   // 方法
            Constructor<?>[] con=objClass.getDeclaredConstructors();    // 构造函数；

            System.out.println("属性：");
            for (Field field : f) {
                System.out.println(field.toString());
            }
            System.out.println("方法：");
            for (Method method : m) {
                System.out.println(method.toString());
            }
            System.out.println("构造函数：");
            for (Constructor<?> constructor : con) {
                System.out.println(constructor.toString());
            }

            // 以上可输出该类的名称：Monster；该类的属性：name, health, damage；该类的方法：attack； 和构造函数：Monster(java.lang.String,int,int)
            // 知道该类的构造函数为 Monster(java.lang.String,int,int)，则利用该构造函数con[0]创建对象实例如下：

            System.out.println("创建对象实例：");
            con[0].setAccessible(true); // 修改权限，没有这句Main类没有访问权限；
            Object snake= con[0].newInstance("snake",100,5);
            System.out.println(snake); // 创建成功；

        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}