package com.clinic.mapper;

import com.clinic.domain.Seance;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface SeanceMapper {

    @Select("SELECT * FROM seance WHERE id=#{id}")
    @Results(
        value = {@Result(property = "id", column = "ID"),
                @Result(property = "date", column = "SEANCE_DATE"),
                @Result(property = "description", column = "DESCRIPTION")
        })
    Seance getSeanceById(int id);

    @Update("UPDATE seance SET seance_date=#{date}, description=#{description} where id=#{id}")
    void updateSeance(@Param("date")Date date, @Param("description")String description, @Param("id")int id);

    @Delete("DELETE FROM seance WHERE id=#{id}")
    void deleteSeance(@Param("id")int id);

    @Insert("INSERT INTO seance (seance_date, description, disease_id) VALUES (#{date}, #{description}, #{disease_id})")
    void addSeance(@Param("date")Date date, @Param("description")String description, @Param("disease_id")int diseaseId);

    @Select("SELECT * FROM seance WHERE disease_id=#{id}")
    List<Seance> getSeanceListByDiseaseId(int id);
}
