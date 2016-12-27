package com.clinic.mapper;

import com.clinic.model.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    final String getUserById = "SELECT * FROM users WHERE id=#{id}";
    final String getUserByLoginPassword = "SELECT * FROM users WHERE login=#{login} AND password=#{password}";

    @Results(
            value = {@Result(property = "id", column = "ID"),
                    @Result(property = "login", column = "LOGIN"),
                    @Result(property = "password", column = "PASSWORD")}
    )

    @Select(getUserById)
    User getUser(int id);

    /*@Select(getUserByLoginPassword)
    User getUser(String login, String password);*/
}
