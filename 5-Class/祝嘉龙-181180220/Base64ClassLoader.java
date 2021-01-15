import java.io.FileInputStream;
import java.util.Base64;

public class Base64ClassLoader extends ClassLoader{
	private byte[] loadByteStream(String name){
		byte[] data = null;
		try{
			FileInputStream fis = new FileInputStream(name);
			data = new byte[fis.available()];
			fis.read(data);
			fis.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return data;
	}
	
	protected Class<?> findClass(String name) throws ClassNotFoundException{
		byte[] data = loadByteStream(name);
		data = Base64.getDecoder().decode(data);
		Class<?> ret = defineClass(null, data, 0, data.length);
		if(ret == null){
			throw new ClassNotFoundException(name);
		}
		return ret;
	}

}
	