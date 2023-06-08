package com.mch.accidents.repository;

import com.mch.accidents.entity.Accident;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentRepositoryMem implements AccidentRepository {

    private final Map<Integer, Accident> accidents = new ConcurrentHashMap<>();

    private AtomicInteger id = new AtomicInteger(1);

    @Override
    public Accident create(Accident accident) {
        accident.setId(id.getAndIncrement());
        accidents.put(accident.getId(), accident);
        return accident;
    }

    @Override
    public boolean update(Accident accident) {
        return accidents.computeIfPresent(accident.getId(),
                (id, oldAccident) -> new Accident(
                        oldAccident.getId(),
                        accident.getName(),
                        accident.getText(),
                        accident.getAddress()
                )) != null;
    }

    @Override
    public List<Accident> findAll() {
        return new ArrayList<>(accidents.values());
    }

    @Override
    public Accident findById(int id) {
        return accidents.get(id);
    }
}