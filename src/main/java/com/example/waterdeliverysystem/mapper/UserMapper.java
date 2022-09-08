package com.example.waterdeliverysystem.mapper;

import com.example.waterdeliverysystem.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {




    @Select("select * from user")
    public List<User> getUserList();

    @Select("select * from user where userName = #{userName} and password = #{password}")
    public User login(User user);

    @Select("select * from user where id = #{id}")
    public User getUserById(int id);


    @Update("update user set password = #{password} where id = #{id}")
    public int updatePassword(User user);


}
