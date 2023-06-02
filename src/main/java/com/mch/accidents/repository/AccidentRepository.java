package com.mch.accidents.repository;

import com.mch.accidents.entity.Accident;

import java.util.List;

public interface AccidentRepository {

    List<Accident> findAll();

}