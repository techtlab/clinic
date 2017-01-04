package com.clinic.mapper;

import com.clinic.model.Disease;
import com.clinic.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserMapper {

    /* User */
    final String getUserById = "SELECT * FROM user WHERE id=#{id}";
    final String getUserByLogin = "SELECT * FROM user WHERE login=#{login}";
    final String getUserByLoginPassword = "SELECT * FROM user WHERE login=#{login} AND password=#{password}";
    final String getUsersByRole = "SELECT * FROM user WHERE role=#{role}";
    final String addNewUser = "INSERT INTO user (login, password, role, name, phone, address) VALUES (#{login}, #{password}, #{role}, #{name}, #{phone}, #{address})";
    final String updateUserInfoByLogin = "UPDATE user SET password=#{password}, role=#{role}, name=#{name}, phone=#{phone}, address=#{address} WHERE login=#{login}";
    final String deleteUser = "DELETE FROM user WHERE login=#{login}";

    /* Disease */
    final String addDisease = "INSERT INTO disease (name, description, cured, user_id) VALUES (#{name}, #{description}, #{cured}, #{user_id})";
    final String getDiseaseListByUserId = "SELECT * FROM disease WHERE user_id=#{id}";


    @Select(getUserById)
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
        }
    )
    User getUserById(int id);

    @Select(getUsersByRole)
    List<User> getUsersByRole(byte role);

    @Select(getUserByLoginPassword)
    User getUserByLoginAndPassword(@Param("login")String login, @Param("password")String password);

    @Select(getUserByLogin)
    User getUserByLogin(String login);

    @Insert(addNewUser)
    void addNewUser(@Param("login")String login, @Param("password")String password, @Param("role")byte role,
                    @Param("name")String name, @Param("phone")String phone, @Param("address")String address);

    @Update(updateUserInfoByLogin)
    void updateUserInfoByLogin(@Param("login")String login, @Param("password")String password, @Param("role")byte role,
                               @Param("name")String name, @Param("phone")String phone, @Param("address")String address);

    @Delete(deleteUser)
    void deleteUser(@Param("login")String login);

    @Insert(addDisease)
    void addDisease(@Param("name")String name, @Param("description")String description,
                    @Param("cured")int cured, @Param("user_id")int userId);

    @Select(getDiseaseListByUserId)
    List<Disease> getDiseaseListByUserId(int id);
}
