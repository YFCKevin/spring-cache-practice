package yfckevin.springcachepractice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
public class RedisConfig {

    /*
    * 設定緩存管理器
    * @param redis多執行緒安全工廠
    * @return 緩存管理器
    * */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        // 利用config對緩存自行定義配置
        RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                // 設定過期時間為30分鐘
                .entryTtl(Duration.ofMinutes(30))
                // 禁止缓存 null 值
                .disableCachingNullValues()
                // 設定 key 序列化
                .serializeKeysWith(keyPair())
                // 設定 value 序列化
                .serializeValuesWith(valuePair());
        // 返回 Redis 缓存管理器
        return RedisCacheManager.builder(factory)
                .withCacheConfiguration("user", cacheConfig).build();
    }

    private RedisSerializationContext.SerializationPair<String> keyPair() {
        return RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer());
    }

    private RedisSerializationContext.SerializationPair<Object> valuePair() {
        return RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer());
    }
}
