package com.example.demo.dao;

import com.example.demo.domin.Accounts;
import com.example.demo.received.BindBody;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface AccountsDao {
    @Insert("INSERT INTO accounts(userid,accountnumber,actype) values(#{userId},#{accountNumber},#{acType})")
    public int insertIntoAccounts(@Param("userId") int userId,@Param("accountNumber") String accountNumber,
                                  @Param("acType") int acType);
    @Select("select * from accounts where userid = #{userId} and actype!=2")
    public ArrayList<Accounts> getAllAccountsById(@Param("userId") int userId);
    @Select("select * from accounts where accountnumber = #{accountnumber} and actype!=2")
    public Accounts getAccountsByNumber(@Param("accountnumber") String accountnumber);
    @Select("select * from accounts where userid = #{userId} and accountNumber = #{accountNumber} and actype = #{acType}")
    public Accounts getOneAccount(@Param("userId") int userId,@Param("accountNumber") String accountNumber,
                                  @Param("acType") int acType);
    @Update("update accounts set accountNumber = #{newNumber} where userid = #{userId} and accountNumber =#{oldNumber}")
    public Accounts updateAccountNumber(BindBody bindBody);
    @Update("update accounts set actype = #{acType} where userid = #{userId} and accountNumber =#{oldNumber}")
    public Accounts updateAccountType(BindBody bindBody);
    @Update("update accounts set RMBIncome = #{income} where acid =#{acid}")
    public void withdrawRMB(@Param("acid")int acid,@Param("income") float income);
    @Update("update accounts set DollarIncome = #{income} where acid =#{acid}")
    public void withdrawDollar(@Param("acid")int acid,@Param("income") float income);
}
