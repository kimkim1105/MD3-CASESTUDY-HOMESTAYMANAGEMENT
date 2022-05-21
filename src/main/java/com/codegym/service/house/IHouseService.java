package com.codegym.service.house;

import com.codegym.model.House;
import com.codegym.service.IGeneralService;

import java.util.List;

public interface IHouseService extends IGeneralService<House> {
    List<House> findByName(String name);
    public List< House> sorfPriceUnder1000();
    public List< House> sorfPrice1000to2000();
    public List< House> sorfPriceOver2000();
}
