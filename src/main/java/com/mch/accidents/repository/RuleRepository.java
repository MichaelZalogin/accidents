package com.mch.accidents.repository;

import com.mch.accidents.entity.Rule;

import java.util.List;

public interface RuleRepository {

 List<Rule> findAll();

}