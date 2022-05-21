package com.codegym.service.standard;

import com.codegym.model.House;
import com.codegym.model.Standard;
import com.codegym.model.Type;
import com.codegym.service.IGeneralService;

import java.util.List;

public interface IStandardService extends IGeneralService<Standard> {
    List<House> getHouseByIdStandardId(int id);
    List<Standard> findAllStandardfromHouses(List<House> houses);
}
