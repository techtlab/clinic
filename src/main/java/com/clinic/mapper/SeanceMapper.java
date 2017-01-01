package com.clinic.mapper;

import com.clinic.model.Seance;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface SeanceMapper {

    final String getSeanceById = "SELECT * FROM seance WHERE id=#{id}";
    final String updateSeance = "UPDATE seance SET seance_date=#{date}, description=#{description} where id=#{id}";
    final String deleteSeance = "DELETE FROM seance WHERE id=#{id}";

    /* TODO: Replace methods to DiseaseMapper */
    final String addSeance = "INSERT INTO seance (seance_date, description, disease_id) VALUES (#{date}, #{description}, #{disease_id})";
    final String getSeanceListByDiseaseId = "SELECT * FROM seance WHERE disease_id=#{id}";


    @Results(
        value = {@Result(property = "id", column = "ID"),
                @Result(property = "date", column = "SEANCE_DATE"),
                @Result(property = "description", column = "DESCRIPTION")
        }
    )

    @Select(getSeanceById)
    Seance getSeanceById(int id);

    @Insert(addSeance)
    void addSeance(@Param("date")Date date, @Param("description")String description, @Param("disease_id")int diseaseId);

    @Update(updateSeance)
    void updateSeance(@Param("date")Date date, @Param("description")String description, @Param("id")int id);

    @Delete(deleteSeance)
    void deleteSeance(@Param("id")int id);

    @Select(getSeanceListByDiseaseId)
    List<Seance> getSeanceListByDiseaseId(@Param("id")int id);
}
