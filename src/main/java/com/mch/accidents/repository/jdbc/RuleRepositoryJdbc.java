package com.mch.accidents.repository.jdbc;

import com.mch.accidents.entity.Rule;
import com.mch.accidents.repository.RuleRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class RuleRepositoryJdbc implements RuleRepository {

    private final JdbcTemplate jdbc;

    @Override
    public List<Rule> findAll() {
        return jdbc.query("""
                        SELECT id, name
                        FROM rule
                        """,
                (resultSet, rowNum) -> {
                    Rule rule = new Rule();
                    rule.setId(resultSet.getInt("id"));
                    rule.setName(resultSet.getString("name"));
                    return rule;
                });
    }

}
