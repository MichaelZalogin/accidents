package com.mch.accidents.service;

import com.mch.accidents.entity.Accident;
import com.mch.accidents.repository.jdbc.AccidentRepositoryJdbc;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccidentService {

    private final AccidentRepositoryJdbc accidentRepository;

    public Accident create(Accident accident) {
        return accidentRepository.create(accident);
    }

    public List<Accident> findAll() {
        return accidentRepository.findAll();
    }

    public Optional<Accident> findById(int id) {
        return accidentRepository.findById(id);
    }

    public boolean update(Accident accident) {
        return accidentRepository.update(accident);
    }

}