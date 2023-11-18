package com.example.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import com.example.demo.domin.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UsersDao {
    @Select("SELECT * FROM users WHERE username=#{name}")
    public Users getByName(@Param("name") String name);
    @Select("SELECT * FROM users WHERE email = #{email}")
    public Users getByEmail(@Param("email") String email);
    @Select("SELECT * FROM users WHERE userid = #{uid}")
    public Users getById(@Param("uid") int uid);
    @Insert("Insert into users(email,username,passwords) values(#{email},#{username},#{passwords}) ")
    public Users insertIntoUsers(@Param("email") String email,@Param("userName") String userName,@Param("passwords") String passwords);
}
