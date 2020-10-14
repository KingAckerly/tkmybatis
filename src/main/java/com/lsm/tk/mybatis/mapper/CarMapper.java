package com.lsm.tk.mybatis.mapper;

import com.lsm.tk.mybatis.entity.CarEntity;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

public interface CarMapper extends Mapper<CarEntity>, MySqlMapper<CarEntity> {
    Integer eraseBrandByIds(List<Long> ids);

    Integer deleteCarBatch(List<Long> ids);

    Integer updateCarBatch(List<CarEntity> carEntities);
}
