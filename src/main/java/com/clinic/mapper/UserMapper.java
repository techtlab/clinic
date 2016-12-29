package com.clinic.mapper;

import com.clinic.model.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper {

    final String getUserById = "SELECT * FROM user WHERE id=#{id}";
    final String getUserByLoginPassword = "SELECT * FROM user WHERE login=#{login} AND password=#{password}";
    final String getUserByRole = "SELECT * FROM user WHERE role=#{role}";
    final String addNewUser = "INSERT INTO user (login, password, role, name, phone, address) VALUES (#{login}, #{password}, #{role}, #{name}, #{phone}, #{address})";
    final String updateUserInfoByLogin = "UPDATE user SET  #{password}, #{role}, #{name}, #{phone}, #{address} WHERE login=#{login}";
    final String deleteUser = "DELETE FROM user WHERE login=#{login}";

    @Results(
            value = {@Result(property = "id", column = "ID"),
                    @Result(property = "login", column = "LOGIN"),
                    @Result(property = "password", column = "PASSWORD")}
    )

    @Select(getUserById)
    User getUser(int id);

    @Select(getUserByRole)
    User getUserByRole(byte role);

    @Select(getUserByLoginPassword)
    User getUserByLoginAndPassword(@Param("login")String login, @Param("password")String password);

    @Insert(addNewUser)
    void addNewUser(@Param("login")String login, @Param("password")String password, @Param("role")byte role, @Param("name")String name, @Param("phone")String phone, @Param("address")String address);

    @Update(updateUserInfoByLogin)
    void updateUserInfoByLogin(@Param("login")String login, @Param("password")String password, @Param("role")byte role, @Param("name")String name, @Param("phone")String phone, @Param("address")String address);

    @Delete(deleteUser)
    void deleteUser(@Param("login")String login);
}
