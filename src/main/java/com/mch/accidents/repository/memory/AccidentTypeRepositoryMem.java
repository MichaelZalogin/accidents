package com.mch.accidents.repository.memory;

import com.mch.accidents.entity.AccidentType;
import com.mch.accidents.repository.AccidentTypeRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AccidentTypeRepositoryMem implements AccidentTypeRepository {

    private final Map<Integer, AccidentType> accidentTypes = new ConcurrentHashMap<>();

    public AccidentTypeRepositoryMem() {
        accidentTypes.put(1, new AccidentType(1, "Две машины"));
        accidentTypes.put(2, new AccidentType(2, "Машина и человек"));
        accidentTypes.put(3, new AccidentType(3, "Машина и велосипед"));
    }

    @Override
    public List<AccidentType> findAll() {
        return new ArrayList<>(accidentTypes.values());
    }

}