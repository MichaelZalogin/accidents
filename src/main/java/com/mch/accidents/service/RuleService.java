package com.mch.accidents.service;

import com.mch.accidents.entity.Rule;
import com.mch.accidents.repository.RuleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RuleService {

    private final RuleRepository ruleRepositoryMem;

    public List<Rule> findAll() {
        return ruleRepositoryMem.findAll();
    }

}