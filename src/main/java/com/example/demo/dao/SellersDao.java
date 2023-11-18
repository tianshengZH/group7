package com.example.demo.dao;

import com.example.demo.domin.Sellers;
import com.example.demo.received.BindSellerBody;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface SellersDao {
    @Insert("insert into sellers(userid,pname,status) values(#{userId},#{newName},#{status})")
    public void insertSellers(BindSellerBody bindSellerBody);
    @Select("select * from sellers where userid = #{userId} and pName = #{pName} and status = 0")
    public Sellers getSellerByName(@Param("userId")int userId,@Param("pName") String pName);
    @Select("select  * from sellers where userId = #{userId} and status = 0")
    public ArrayList<Sellers> getAllSellersById(@Param("userId") int userId);
    @Update("Update sellers set pname = #{newName} where userId = #{userId}")
    public Sellers updateSellerName(BindSellerBody bindSellerBody);
    @Update("Update sellers set status = 1 where userId = #{userId} and pname = #{newName}")
    public Sellers deleteSeller(BindSellerBody bindSellerBody);


}
