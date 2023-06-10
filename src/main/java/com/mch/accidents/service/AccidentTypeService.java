package com.mch.accidents.service;

import com.mch.accidents.entity.AccidentType;
import com.mch.accidents.repository.AccidentTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccidentTypeService {

    private final AccidentTypeRepository accidentTypeRepository;

    public List<AccidentType> findAll() {
        return accidentTypeRepository.findAll();
    }

}