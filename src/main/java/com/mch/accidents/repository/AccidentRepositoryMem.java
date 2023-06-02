package com.mch.accidents.repository;

import com.mch.accidents.entity.Accident;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AccidentRepositoryMem implements AccidentRepository {

    private final Map<Integer, Accident> accidents = new ConcurrentHashMap<>();

    @Override
    public List<Accident> findAll() {
        return new ArrayList<>(accidents.values());
    }

}