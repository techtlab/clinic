package com.clinic.mapper;

import com.clinic.domain.Seance;
import org.apache.ibatis.annotations.*;

import java.util.Date;

public interface SeanceMapper {

    final String getSeanceById = "SELECT * FROM seance WHERE id=#{id}";
    final String updateSeance = "UPDATE seance SET seance_date=#{date}, description=#{description} where id=#{id}";
    final String deleteSeance = "DELETE FROM seance WHERE id=#{id}";


    @Select(getSeanceById)
    @Results(
        value = {@Result(property = "id", column = "ID"),
                @Result(property = "date", column = "SEANCE_DATE"),
                @Result(property = "description", column = "DESCRIPTION")
        }
    )
    Seance getSeanceById(int id);

    @Update(updateSeance)
    void updateSeance(@Param("date")Date date, @Param("description")String description, @Param("id")int id);

    @Delete(deleteSeance)
    void deleteSeance(@Param("id")int id);
}
