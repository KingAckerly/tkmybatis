package com.lsm.tk.mybatis.service;

import com.lsm.tk.mybatis.entity.CarEntity;

import java.util.List;

public interface ICarService {
    int addCar(CarEntity carEntity);

    int deleteCar(Long id);

    int updateCar(CarEntity carEntity);

    CarEntity getCar(Long id);

    List<CarEntity> listCars();
}
