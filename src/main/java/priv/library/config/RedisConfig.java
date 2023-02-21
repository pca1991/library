package priv.library.config;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import priv.library.config.serializer.JsonRedisSerializer;

import javax.annotation.Resource;
import java.time.Duration;

/**
 * @author Austin
 * @description Redis配置
 * @date 2023/2/19 16:35
 */
@Configuration
public class RedisConfig {
    @Resource
    private JedisConnectionFactory factory;



    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new JsonRedisSerializer<>(Object.class));
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new JsonRedisSerializer<>(Object.class));
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }



    @Bean
    public RedisCacheManagerBuilderCustomizer myRedisCacheManagerBuilderCustomizer() {
        return (builder) -> {
            // 序列化格式使用json
            RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig().serializeKeysWith(
                            RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                    .serializeValuesWith(RedisSerializationContext.SerializationPair
                            .fromSerializer(new JsonRedisSerializer<>(Object.class)));
            // 默认过期时间：10分钟
            builder.cacheDefaults(config.entryTtl(Duration.ofMinutes(10)));

            //特殊key过期时间配置
            //builder.withCacheConfiguration(MidRedisKey.orgIdKey, config.entryTtl(Duration.ofDays(1)));
        };


    }
}
