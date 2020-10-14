package com.lsm.tk.mybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lsm.tk.mybatis.mapper.CarMapper;
import com.lsm.tk.mybatis.entity.CarEntity;
import com.lsm.tk.mybatis.service.ICarService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public int deleteCarBatch(List<Long> ids) {
        return carMapper.deleteCarBatch(ids);
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

    @Override
    public PageInfo<CarEntity> listPageCars() {
        PageHelper.startPage(2, 1);
        List<CarEntity> carEntityList = carMapper.selectAll();
        PageInfo<CarEntity> page = new PageInfo<>(carEntityList);
        return page;
    }

    @Override
    public int saveBatchCars(List<CarEntity> carEntities) {
        int i = carMapper.insertList(carEntities);
        System.out.println(carEntities);
        return i;
    }

    @Override
    public int eraseBrandByIds(List<Long> ids) {
        return carMapper.eraseBrandByIds(ids);
    }

    @Transactional
    @Override
    public void updateCarBatch(List<CarEntity> carEntities) {
        //每次执行的数量
        int post = 3;
        int fromIndex = 0;
        //初始截取索引=执行数量
        int toIndex = post;
        //源集合长度
        int size = carEntities.size();
        //需要分批执行的总次数
        int total = size % post == 0 ? size / post : size / post + 1;
        //承载分批次执行的集合
        List newList = new ArrayList<>();
        //当前执行次数
        int index = 1;
        while (true) {
            if (index < total) {
                newList = carEntities.subList(fromIndex, toIndex);
                carMapper.updateCarBatch(newList);
                fromIndex = toIndex;
                toIndex += post;
                index++;
            }
            if (index == total) {
                newList = carEntities.subList(fromIndex, size);
                carMapper.updateCarBatch(newList);
                break;
            }
        }
    }
}
