import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) {
        MyClassLoader loader = new MyClassLoader();
        String classByte = "yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=";

        try {
            Class myClass = loader.loadClass(classByte);        //从字节码中读取类
            System.out.println(myClass.getName());  //打印类名
            for (Constructor c : myClass.getDeclaredConstructors()) {   //打印构造函数
                System.out.println(c.toString());
            }
            for (Method m : myClass.getDeclaredMethods()) { //打印方法
                System.out.println(m.toString());
            }
            for (Field f : myClass.getDeclaredFields()) {   //打印成员变量
                System.out.println(f.toString());
            }

            Constructor c = myClass.getDeclaredConstructor(new Class[]{String.class, int.class, int.class});
            c.setAccessible(true);
            Object monster = c.newInstance(new Object[]{(String) "monster", 100, 5}); //等价于Monster monster = new Monster("monster", 100, 5)

            Field f = myClass.getDeclaredField("health");//等价于monster.health
            System.out.println("\nBefore attack, monster.health = " + f.get(monster));

            System.out.println("Test 'monster.attack(monster)'");
            Method m = myClass.getDeclaredMethod("attack", myClass);
            String res = (String) m.invoke(monster, monster);     //等价于monster.attack(monster)
            System.out.println(res);

            System.out.println("After attack, monster.health = " + f.get(monster));
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
}
