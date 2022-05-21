package com.codegym.service.type;

import com.codegym.model.House;
import com.codegym.model.Standard;
import com.codegym.model.Type;
import com.codegym.service.IGeneralService;

import java.util.List;

public interface ITypeService extends IGeneralService<Type> {
    List<House> getHouseByIdTypeId(int id);
    List<Type> findAllTypefromHouses(List<House> houses);
}
