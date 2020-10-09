package com.lsm.tk.mybatis.service;

import com.github.pagehelper.PageInfo;
import com.lsm.tk.mybatis.entity.CarEntity;

import java.util.List;

public interface ICarService {
    int addCar(CarEntity carEntity);

    int deleteCar(Long id);

    int updateCar(CarEntity carEntity);

    CarEntity getCar(Long id);

    List<CarEntity> listCars();

    PageInfo<CarEntity> listPageCars();

    int saveBatchCars(List<CarEntity> carEntities);

    int eraseBrandByIds(List<Long> ids);
}
