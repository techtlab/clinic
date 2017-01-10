package com.clinic.mapper;

import com.clinic.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserMapper {

    @Select("SELECT * FROM user WHERE id=#{id}")
    @Results(
        value = {@Result(property = "id", column = "ID"),
                @Result(property = "login", column = "LOGIN"),
                @Result(property = "password", column = "PASSWORD"),
                @Result(property = "role", column = "ROLE"),
                @Result(property = "name", column = "NAME"),
                @Result(property = "phone", column = "PHONE"),
                @Result(property = "address", column = "ADDRESS"),
                @Result(property = "diseases", column = "id", javaType = List.class,
                        many = @Many(select = "getDiseaseListByUserId", fetchType = FetchType.DEFAULT))
        })
    User getUserById(int id);

    @Select("SELECT * FROM user WHERE role=#{role}")
    List<User> getUsersByRole(byte role);

    @Select("SELECT * FROM user WHERE login=#{login} AND password=#{password}")
    User getUserByLoginAndPassword(@Param("login")String login, @Param("password")String password);

    @Select("SELECT * FROM user WHERE login=#{login}")
    User getUserByLogin(String login);

    @Insert("INSERT INTO user (login, password, role, name, phone, address) " +
            "VALUES (#{login}, #{password}, #{role}, #{name}, #{phone}, #{address})")
    void addNewUser(@Param("login")String login, @Param("password")String password, @Param("role")byte role,
                    @Param("name")String name, @Param("phone")String phone, @Param("address")String address);

    @Update("UPDATE user SET password=#{password}, role=#{role}, name=#{name}, " +
            "phone=#{phone}, address=#{address} WHERE login=#{login}")
    void updateUserInfoByLogin(@Param("login")String login, @Param("password")String password, @Param("role")byte role,
                               @Param("name")String name, @Param("phone")String phone, @Param("address")String address);

    @Delete("DELETE FROM user WHERE login=#{login}")
    void deleteUser(@Param("login")String login);
}
