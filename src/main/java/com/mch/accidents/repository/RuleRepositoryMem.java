package com.mch.accidents.repository;

import com.mch.accidents.entity.Rule;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class RuleRepositoryMem implements RuleRepository {

    private final Map<Integer, Rule> ruleStore = new ConcurrentHashMap<>();

    public RuleRepositoryMem() {
        ruleStore.put(1, new Rule(1, "Статья. 1"));
        ruleStore.put(2, new Rule(2, "Статья. 2"));
        ruleStore.put(3, new Rule(3, "Статья. 3"));
    }

    @Override
    public List<Rule> findAll() {
        return new ArrayList<>(ruleStore.values());
    }

}