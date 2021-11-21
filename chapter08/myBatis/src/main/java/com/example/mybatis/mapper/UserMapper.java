package com.example.mybatis.mapper;

import com.example.mybatis.entity.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User queryById(@Param("id") int id);

    /**
     * pageHelper直接在limit后加了limit条件，导致SQL报错，暂时先去掉limit条件
     * @return
     */
    @Select("select * from user")
    List<User> queryAll();

    @Insert("insert into user(name,age) values(#{name},#{age})")
    int add(User user);

    @Delete("delete from user where id = #{id}")
    int deleteById(@Param("id") int id);

    @Update("update user set name=#{name}, age=#{age} where id = #{id}")
    int updateById(User user);

    /**
     * 直接返回page对象
     * @return
     */
    @Select("select * from user")
    Page<User> getUserPage();

}
