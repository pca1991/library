package priv.library.config.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.IOUtils;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * @author Austin
 * @description Redis序列化
 * @date 2023/2/19 16:26
 */
public class JsonRedisSerializer<T> implements RedisSerializer<T> {
    private static ParserConfig defaultRedisConfig = new ParserConfig();
    private Class<T> type;

    static {
        defaultRedisConfig.setAutoTypeSupport(true);
    }

    public JsonRedisSerializer(Class<T> type) {
        this.type = type;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return null;
        }
        return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(IOUtils.UTF8);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        String str = new String(bytes, IOUtils.UTF8);

        return JSON.parseObject(str, type, defaultRedisConfig);
    }
}
