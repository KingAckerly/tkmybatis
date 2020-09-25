package com.lsm.tk.mybatis.mapper;

import com.lsm.tk.mybatis.entity.CarEntity;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface CarMapper extends Mapper<CarEntity>, MySqlMapper<CarEntity> {
}
