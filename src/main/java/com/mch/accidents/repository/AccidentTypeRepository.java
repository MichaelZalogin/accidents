package com.mch.accidents.repository;

import com.mch.accidents.entity.AccidentType;
import java.util.List;

public interface AccidentTypeRepository {

 List<AccidentType> findAll();

}