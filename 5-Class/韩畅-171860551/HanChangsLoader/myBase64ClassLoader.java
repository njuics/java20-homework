package HanChangsLoader;

import java.util.Base64;

public class myBase64ClassLoader extends ClassLoader {

	// 从字符串中加载类
	protected Class<?> findClass(String base64String){
		byte[] base64Buf = Base64.getDecoder().decode(base64String);
		return defineClass(null, base64Buf, 0, base64Buf.length);
	}
	
}
