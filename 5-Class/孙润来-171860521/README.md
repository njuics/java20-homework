# 自定义加载器
将base64字节码字符串作为静态成员

myClassLoader继承ClassLoader并重写findClass函数

对base64字符串进行解码，解码出来的byte[]作为参数传递给defineClass

# 反射
首先通过findClass生成这样的一个类`Class c = myloader.findClass("")`

通过`getCanonicalName()`于`getDeclaredConstructors()`方法获取到类的名字和构造函数

然后便可以通过带参构造函数的参数类型生成构造器并初始化一个实例对象

关于类的属性和方法可以使用最开始的findClass构造的类通过反射来获取，也可以使用对象实例通过`getClass()`方法后再获取
