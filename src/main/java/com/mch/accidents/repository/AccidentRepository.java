package com.mch.accidents.repository;

import com.mch.accidents.entity.Accident;

import java.util.List;

public interface AccidentRepository {

    Accident create(Accident accident);

    boolean update(Accident accident);

    List<Accident> findAll();

    Accident findById(int id);

}