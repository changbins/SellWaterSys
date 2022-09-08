package com.example.waterdeliverysystem.mapper;

import com.example.waterdeliverysystem.model.Customer;
import com.example.waterdeliverysystem.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomerMapper {




    @Select("select * from customer")
    public List<Customer> getCustomerList();

    //queryCustomer
    @Select("select * from customer where customerName like concat ('%' ,#{customerName},'%') or" +
            " address like concat ('%' ,#{customerName},'%')")
    public List<Customer> getCustomerListByCustomerName(String cusstomer);

    @Insert("insert into customer (customerName,address,tel,ticket)values(#{customerName}" +
            ",#{address},#{tel},#{ticket})")
    int addCustomer(Customer customer);

//    @Select("select * from user where userName = #{userName} and password = #{password}")
//    public User login(User user);
//
    @Select("select * from customer where id = #{id}")
    public Customer getCustomerById(int id);
//
//
    @Update("update customer set customerName = #{customerName},address = #{address}," +
            "tel = #{tel},ticket=#{ticket} where id = #{id}")
    public int updateCustomer(Customer customer);


    @Delete("delete from customer where id = #{id}")
    public int deleteCustomerById(int id);
}
