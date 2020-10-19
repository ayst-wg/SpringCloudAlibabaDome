package com.wanggang.alibaba.dao;

import com.wanggang.alibaba.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * @ClassName : RedisDao
 * @Description : RedisDao
 * @Author : wanggang
 * @Date: 2020-10-19 15:33
 * @Version 1.0
 **/
@Mapper
public interface RedisDao {

    @Insert("INSERT INTO T_User(id,username,age,address) VALUES(null,#{username},#{age},#{address})")
    public int insert(User user);

    @Update("UPDATE T_User SET username = #{username}, age = #{age} , address = #{address} WHERE id = #{id}")
    public int update(User user);

    @Delete("DELETE FROM T_User WHERE id = #{id}")
    public int delete(@Param("id") long id);

    @Select("SELECT * FROM T_User WHERE id = #{id}")
    public User getUserById(@Param("id") long id);

    @Select("SELECT * FROM T_User WHERE username = #{username} and age = #{age} and address = #{address} order by id desc limit 0,1")
    public User getUserSortId(User user);

}
