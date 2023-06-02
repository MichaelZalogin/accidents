package com.mch.accidents.service;

import com.mch.accidents.entity.Accident;
import com.mch.accidents.repository.AccidentRepositoryMem;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class AccidentService {

    private final AccidentRepositoryMem accidentRepositoryMem;

    public List<Accident> findAll() {
        return accidentRepositoryMem.findAll();
    }

}