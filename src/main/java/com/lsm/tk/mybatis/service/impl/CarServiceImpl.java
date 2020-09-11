package com.lsm.tk.mybatis.service.impl;

import com.lsm.tk.mybatis.mapper.CarMapper;
import com.lsm.tk.mybatis.entity.CarEntity;
import com.lsm.tk.mybatis.service.ICarService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CarServiceImpl implements ICarService {

    @Resource
    private CarMapper carMapper;

    @Override
    public int addCar(CarEntity carEntity) {
        return carMapper.insert(carEntity);
    }

    @Override
    public int deleteCar(Long id) {
        return carMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateCar(CarEntity carEntity) {
        String brand = "宝马";
        Example example = new Example(CarEntity.class);
        example.createCriteria().andEqualTo("brand", brand);
        return carMapper.updateByExample(carEntity, example);
    }

    @Override
    public CarEntity getCar(Long id) {
        return carMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CarEntity> listCars() {
        return carMapper.selectAll();
    }
}
