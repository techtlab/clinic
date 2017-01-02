package com.clinic.mapper;

import com.clinic.model.Disease;
import com.clinic.model.Seance;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.Date;
import java.util.List;

public interface DiseaseMapper {

    /* Disease */
    final String getDiseaseById = "SELECT * FROM disease WHERE id=#{id}";
    final String updateDiseaseById = "UPDATE disease SET name=#{name}, description=#{description}, cured=#{cured} WHERE id=#{id}";
    final String deleteDiseaseById = "DELETE FROM disease WHERE id=#{id}";

    /* Seance */
    final String addSeance = "INSERT INTO seance (seance_date, description, disease_id) VALUES (#{date}, #{description}, #{disease_id})";
    final String getSeanceListByDiseaseId = "SELECT * FROM seance WHERE disease_id=#{id}";


    @Select(getDiseaseById)
    @Results(
        value = {@Result(property = "id", column = "ID"),
                @Result(property = "name", column = "NAME"),
                @Result(property = "description", column = "DESCRIPTION"),
                @Result(property = "cured", column = "CURED"),
                @Result(property = "seances", column = "id", javaType = List.class,
                        many = @Many(select = "getSeanceListByDiseaseId", fetchType = FetchType.DEFAULT))
        }
    )
    Disease getDiseaseById(int id);

    @Update(updateDiseaseById)
    void updateDisease(@Param("name")String name, @Param("description")String description,
                       @Param("cured")int cured, @Param("id")int id);

    @Delete(deleteDiseaseById)
    void deleteDisease(int id);

    @Insert(addSeance)
    void addSeance(@Param("date")Date date, @Param("description")String description, @Param("disease_id")int diseaseId);

    @Select(getSeanceListByDiseaseId)
    List<Seance> getSeanceListByDiseaseId(int id);
}
