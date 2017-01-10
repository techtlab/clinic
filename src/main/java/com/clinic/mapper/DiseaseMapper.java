package com.clinic.mapper;

import com.clinic.domain.Disease;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface DiseaseMapper {

    @Select("SELECT * FROM disease WHERE id=#{id}")
    @Results(
        value = {@Result(property = "id", column = "ID"),
                @Result(property = "name", column = "NAME"),
                @Result(property = "description", column = "DESCRIPTION"),
                @Result(property = "cured", column = "CURED"),
                @Result(property = "seances", column = "id", javaType = List.class,
                        many = @Many(select = "getSeanceListByDiseaseId", fetchType = FetchType.DEFAULT))
        })
    Disease getDiseaseById(int id);

    @Update("UPDATE disease SET name=#{name}, description=#{description}, cured=#{cured} WHERE id=#{id}")
    void updateDisease(@Param("name")String name, @Param("description")String description,
                       @Param("cured")int cured, @Param("id")int id);

    @Delete("DELETE FROM disease WHERE id=#{id}")
    void deleteDisease(int id);

    @Insert("INSERT INTO disease (name, description, cured, user_id) " +
            "VALUES (#{name}, #{description}, #{cured}, #{user_id})")
    void addDisease(@Param("name")String name, @Param("description")String description,
                    @Param("cured")int cured, @Param("user_id")int userId);

    @Select("SELECT * FROM disease WHERE user_id=#{id}")
    List<Disease> getDiseaseListByUserId(int id);
}
