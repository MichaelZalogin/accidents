package com.mch.accidents.repository.jdbc;

import com.mch.accidents.entity.Accident;
import com.mch.accidents.repository.AccidentRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class AccidentRepositoryJdbc implements AccidentRepository {

    private final JdbcTemplate jdbc;

    @Override
    public Accident create(Accident accident) {
        jdbc.update("""
                        INSERT INTO accident (name)
                        VALUES (?)
                        """,
                accident.getName());
        return accident;
    }

    public Accident create2(Accident accident) {
        jdbc.update("""
                        INSERT INTO accident (name)
                        VALUES (?)
                        """,
                accident.getName());
        return accident;
    }

    @Override
    public boolean update(Accident accident) {
        return jdbc.update(
                """
                        UPDATE accident
                        SET name = ?
                        WHERE id = ?
                        """,
                accident.getName(),
                accident.getId()) > 1;
    }

    @Override
    public List<Accident> findAll() {
        return jdbc.query("""
                        SELECT id, name
                        FROM accident
                        """,
                (resultSet, rowNum) -> {
                    Accident accident = new Accident();
                    accident.setId(resultSet.getInt("id"));
                    accident.setName(resultSet.getString("name"));
                    return accident;
                });
    }

    @Override
    public Optional<Accident> findById(int id) {
        return Optional.ofNullable(jdbc.queryForObject("""
                        SELECT id, name
                        FROM accident
                        WHERE id = ?
                        """,
                (resultSet, rowNum) -> {
                    Accident accident = new Accident();
                    accident.setId(resultSet.getInt("id"));
                    accident.setName(resultSet.getString("name"));
                    return accident;
                }, id));
    }

}