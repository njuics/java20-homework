package hulubattle.game.data;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.google.common.io.CharStreams;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 从 JSON 文件或字符串中读取对象数组，然后加载进内存
 */
public class JsonDataSupplier<T extends Data> implements DataSupplier<T> {
    private static final Gson gson = new Gson();
    private final Class<? extends T> typeClass;
    private Map<Integer, T> map = new HashMap<>();

    /**
     * 字符串构造器，使用 JSON 字符串作为数据源
     *
     * @param typeClass 具体存储的类型的 Class 对象，继承自 T
     * @param string    JSON 字符串
     */
    public JsonDataSupplier(Class<? extends T> typeClass, String string) {
        this.typeClass = typeClass;
        setDataSource(string);
    }

    /**
     * 文件构造器，使用一个路径作为数据源
     *
     * @param typeClass 具体存储的类型的 Class 对象，继承自 T
     * @param url       JSON 文件所在的路径
     * @throws IOException 读文件错时抛出
     */
    public JsonDataSupplier(Class<? extends T> typeClass, URL url) throws IOException {
        this.typeClass = typeClass;
        setDataSource(url);
    }

    private void setDataSource(String string) {
        Type type = TypeToken.getParameterized(ArrayList.class, typeClass).getType();
        map = new HashMap<>();
        List<T> list = gson.fromJson(string, type);
        list.forEach(t -> map.put(t.getId(), t));
    }

    private void setDataSource(URL url) throws IOException {
        URL u = Optional.ofNullable(url).orElseThrow(() -> new IOException("URL not exist"));
        String string = CharStreams.toString(new InputStreamReader(u.openStream(), StandardCharsets.UTF_8));
        setDataSource(string);
    }

    @Override
    public Optional<T> get(int id) {
        return Optional.ofNullable(map.get(id));
    }
}
