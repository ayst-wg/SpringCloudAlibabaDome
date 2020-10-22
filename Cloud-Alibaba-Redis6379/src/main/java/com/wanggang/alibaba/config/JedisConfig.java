package com.wanggang.alibaba.config;

/**
 * @ClassName : JedisConfig
 * @Description : Jedis Pool config
 * @Author : wanggang
 * @Date: 2020-10-22 15:01
 * @Version 1.0
 **/
public class JedisConfig {
    /**
     * 把任何数据保存到redis时，都需要进行序列化，默认使用JdkSerializationRedisSerializer进行序列化。
     * 默认的序列化会给所有的key,value的原始字符前，都加了一串字符（例如：\xAC\xED\x00\），不具备可读性
     * 所以需要配置jackson序列化方式
     */

}