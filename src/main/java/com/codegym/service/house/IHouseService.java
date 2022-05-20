package com.codegym.service.house;

import com.codegym.model.House;
import com.codegym.service.IGeneralService;

import java.util.List;

public interface IHouseService extends IGeneralService<House> {
    List<House> findByName(String name);
}
