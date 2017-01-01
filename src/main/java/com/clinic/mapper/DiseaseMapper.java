package com.clinic.mapper;

import com.clinic.model.Disease;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DiseaseMapper {

    /* TODO: Refactoring names and requests */
    final String getDiseaseById = "SELECT * FROM disease WHERE id=#{id}";
    final String updateDiseaseById = "UPDATE disease SET name=#{name}, description=#{description}, cured=#{cured} WHERE id=#{id}";
    final String deleteDiseaseById = "DELETE FROM disease WHERE id=#{id}";

    /* TODO: Replace method to DiseaseMapper */
    final String addDisease = "INSERT INTO disease (name, description, cured, user_id) VALUES (#{name}, #{description}, #{cured}, #{user_id})";
    final String getDiseaseListByUserId = "SELECT * FROM disease WHERE user_id=#{id}";


    @Results(
            value = {@Result(property = "id", column = "ID"),
                    @Result(property = "name", column = "NAME"),
                    @Result(property = "description", column = "DESCRIPTION"),
                    @Result(property = "cured", column = "CURED")
            }
    )

    @Select(getDiseaseById)
    Disease getDiseaseById(int id);

    @Update(updateDiseaseById)
    void updateDisease(@Param("name")String name, @Param("description")String description,
                       @Param("cured")int cured, @Param("id")int id);

    @Delete(deleteDiseaseById)
    void deleteDisease(int id);

    @Insert(addDisease)
    void addDisease(@Param("name")String name, @Param("description")String description,
                    @Param("cured")int cured, @Param("user_id")int userId);

    @Select(getDiseaseListByUserId)
    List<Disease> getDiseaseListByUserId(int id);

}
