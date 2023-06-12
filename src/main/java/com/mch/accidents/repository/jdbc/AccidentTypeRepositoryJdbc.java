package com.mch.accidents.repository.jdbc;

import com.mch.accidents.entity.AccidentType;
import com.mch.accidents.repository.AccidentTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class AccidentTypeRepositoryJdbc implements AccidentTypeRepository {

    private final JdbcTemplate jdbc;

    @Override
    public List<AccidentType> findAll() {
        return jdbc.query("""
                        SELECT id, name
                        FROM accident_type
                        """,
                (resultSet, rowNum) -> {
                    AccidentType accidentType = new AccidentType();
                    accidentType.setId(resultSet.getInt("id"));
                    accidentType.setName(resultSet.getString("name"));
                    return accidentType;
                });
    }

}