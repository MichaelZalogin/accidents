package com.mch.accidents.repository;

import com.mch.accidents.entity.Accident;

import java.util.List;
import java.util.Optional;

public interface AccidentRepository {

    Accident create(Accident accident);

    boolean update(Accident accident);

    List<Accident> findAll();

    Optional<Accident> findById(int id);

}