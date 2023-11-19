package com.example.demo.dao;

import com.example.demo.domin.Bills;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface BillsDao {
    @Insert("insert into bills(pid,dollarincome,billstatus) values(#{pid},#{income},0)")
    public void insertBills(@Param("pid") int pid, @Param("income") float income);
    @Select("select * from bills where pid = #{pid}")
    public ArrayList<Bills> getAllBills(@Param("pid") int pid);
    @Select("select * from bills where bid = #{bid}")
    public Bills getBills(@Param("bid") int bid);

    @Update("update bills set billstatus = 1 where bid = #{bid}")
    public  void updateStatus(@Param("bid") int bid);

}
