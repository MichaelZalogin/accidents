package com.mch.accidents.service;

import com.mch.accidents.entity.Accident;
import com.mch.accidents.repository.AccidentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccidentService {

    private final AccidentRepository accidentRepositoryMem;

    public Accident create(Accident accident) {
        return accidentRepositoryMem.create(accident);
    }

    public List<Accident> findAll() {
        return accidentRepositoryMem.findAll();
    }

    public Accident findById(int id) {
        return accidentRepositoryMem.findById(id);
    }

    public boolean update(Accident accident) {
        return accidentRepositoryMem.update(accident);
    }

}