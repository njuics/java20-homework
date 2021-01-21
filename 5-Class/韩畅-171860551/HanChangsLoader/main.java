package HanChangsLoader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class main {

	public static final String base64Str = "yv66vgAAADQAKgoAAgADBwAEDAAFAAYBABBqYXZhL2xhbmcvT2JqZWN0AQAGPGluaXQ+AQADKClWCAAIAQAHTW9uc3RlcgkACgALBwAIDAAMAA0BAARuYW1lAQASTGphdmEvbGFuZy9TdHJpbmc7CQAKAA8MABAAEQEABmhlYWx0aAEAAUkJAAoAEwwAFAARAQAGZGFtYWdlCAAWAQAcJXMgYXR0YWNrcyAlcyBmb3IgJWQgZGFtYWdlIQoAGAAZBwAaDAAbABwBABFqYXZhL2xhbmcvSW50ZWdlcgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7CgAeAB8HACAMACEAIgEAEGphdmEvbGFuZy9TdHJpbmcBAAZmb3JtYXQBADkoTGphdmEvbGFuZy9TdHJpbmc7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL1N0cmluZzsBABcoTGphdmEvbGFuZy9TdHJpbmc7SUkpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAAZhdHRhY2sBAB0oTE1vbnN0ZXI7KUxqYXZhL2xhbmcvU3RyaW5nOwEAClNvdXJjZUZpbGUBAAxNb25zdGVyLmphdmEAIQAKAAIAAAADAAEADAANAAAAAQAQABEAAAABABQAEQAAAAIAAAAFACMAAQAkAAAAWAACAAQAAAAkKrcAASoSB7UACSoEtQAOKgS1ABIqK7UACSoctQAOKh21ABKxAAAAAQAlAAAAIgAIAAAABwAEAAIACgADAA8ABAAUAAgAGQAJAB4ACgAjAAsAAQAmACcAAQAkAAAASwAFAAIAAAAvK1m0AA4qtAASZLUADhIVBr0AAlkDKrQACVNZBCu0AAlTWQUqtAASuAAXU7gAHbAAAAABACUAAAAKAAIAAAAQAA0AEQABACgAAAACACk=";
	
	public static void main(String[] args) {
		myBase64ClassLoader mainLoader = new myBase64ClassLoader();
		StringBuilder resBd = new StringBuilder();
		
		// 加载类
		Class<?> unknownClass = mainLoader.findClass(base64Str);
		
		resBd.append("class name :\n");
		resBd.append("\t" + unknownClass + "\n");
			
		// 获取构造器
		Constructor<?>[] unknownConstructors = unknownClass.getConstructors();
		Constructor<?>[] unknownDeclaredConstructors = unknownClass.getDeclaredConstructors();
		resBd.append("Class Constructors :\n");
		for (int i = 0; i < unknownConstructors.length; ++i) {
			resBd.append("\t" + unknownConstructors[i] + "\n");
		}
		resBd.append("Class Declared Constructors :\n");
		for (int i = 0; i < unknownDeclaredConstructors.length; ++i) {
			resBd.append("\t" + unknownDeclaredConstructors[i] + "\n");
		}
		
		// 获取属性和方法列表	
		Field[] fs = unknownClass.getFields();
		Method[] ms = unknownClass.getMethods();
		Field[] dfs = unknownClass.getDeclaredFields();
		Method[] dms = unknownClass.getDeclaredMethods();

		resBd.append("Class Fields :\n");
		for (int i = 0; i < fs.length; ++i) {
			resBd.append("\t" + fs[i] + "\n");
		}
		resBd.append("Declared Class Fields :\n");
		for (int i = 0; i < dfs.length; ++i) {
			resBd.append("\t" + dfs[i] + "\n");
		}
		resBd.append("Class Methods :\n");
		for (int i = 0; i < ms.length; ++i) {
			resBd.append("\t" + ms[i] + "\n");
		}
		resBd.append("Declared Class Methods :\n");
		for (int i = 0; i < dms.length; ++i) {
			resBd.append("\t" + dms[i] + "\n");
		}
		
		try {
			if (unknownDeclaredConstructors.length != 0) {
				Constructor<?> dclrConstructor = unknownDeclaredConstructors[0];
				// 从某个构造器中获取构造函数参数类型列表
				Class<?>[] paraType = dclrConstructor.getParameterTypes();
				resBd.append("Declared Constructor Parameters :\n");
				for (int i = 0; i < paraType.length; ++i) {
					resBd.append("\t" + paraType[i] + "\n");
				}
				// 创建参数列表
				Object []paras = new Object[paraType.length];
				// 尝试使用参数类型创建实例
				for (int i = 0; i < paraType.length; ++i) {			
					// 对基础类型进行适配
					if (paraType[i] == int.class) {
						paras[i] = new Integer(0);
					}
					else if (paraType[i] == char.class) {
						paras[i] = new Character(' ');
					}
					else if (paraType[i] == byte.class) {
						paras[i] = new Byte((byte) 0);
					}	
					else if (paraType[i] == double.class) {
						paras[i] = new Double(0);
					}
					else if (paraType[i] == float.class) {
						paras[i] = new Float(0);
					}
					else if (paraType[i] == long.class) {
						paras[i] = new Long(0);
					}
					else if (paraType[i] == boolean.class) {
						paras[i] = new Boolean(false);
					}
					else{
						paras[i] = paraType[i].newInstance();
					}
				}
				dclrConstructor.setAccessible(true);
				// 尝试使用生成的参数表创建实例
				Object obj = dclrConstructor.newInstance(paras);
				resBd.append("The Instance Created:\n\t" + obj);
			}
			// 原方案（动态性不足）
//			Constructor<?> dclrConstructor = unknownClass.getDeclaredConstructor(String.class, int.class, int.class);
//			dclrConstructor.setAccessible(true);
//			Object obj = dclrConstructor.newInstance("MonsterInstance", 2333, 2333);
//			resBd.append("The Instance Created:\n\t" + obj);
			
		} catch (SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print(resBd.toString());
	}
}
