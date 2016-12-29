package com.clinic.mapper;

import com.clinic.model.Seance;
import org.apache.ibatis.annotations.*;

import java.util.Date;

public interface SeanceMapper {

    final String getSeanceByDate = "SELECT * FROM seance WHERE seance_date=#{seance_date}";
    final String addNewSeance = "INSERT INTO seance (seance_date, description) VALUES (#{seance_date}, #{description})";
    final String updateSeance = "UPDATE seance SET seance_date=#{seance_date}, description=#{description} where disease_id=#{disease_id}";
    final String deleteSeance = "DELETE FROM seance WHERE seance_date=#{seance_date} AND disease_id=#{disease_id}";

    @Results(
            value = {@Result(property = "id", column = "ID"),
                    @Result(property = "seance_date", column = "SEANCE_DATE"),
                    @Result(property = "description", column = "DESCRIPTION"),
                    @Result(property = "disease_id", column = "DISEASE_ID")
            }
    )

    @Select(getSeanceByDate)
    Seance getSeanceByDate(Date date);

    @Insert(addNewSeance)
    void addNewSeance(@Param("seance_date")Date seance_date, @Param("description")String description);

    @Update(updateSeance)
    void updateSeance(@Param("seance_date")Date seance_date, @Param("description")String description, @Param("disease_id")int disease_id);

    @Delete(deleteSeance)
    void deleteSeance(@Param("seance_date")Date seance_date, @Param("description")String description, @Param("disease_id")int disease_id);

}
