package com.lsm.tk.mybatis.controller;

import com.github.pagehelper.PageInfo;
import com.lsm.tk.mybatis.entity.CarEntity;
import com.lsm.tk.mybatis.service.ICarService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/car")
public class CarController {

    @Resource
    ICarService carService;

    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public int addCar(@RequestBody CarEntity carEntity) {
        return carService.addCar(carEntity);
    }

    @RequestMapping(value = "/deleteCar", method = RequestMethod.POST)
    public int deleteCar(@RequestParam(value = "id") Long id) {
        return carService.deleteCar(id);
    }

    @RequestMapping(value = "/updateCar", method = RequestMethod.POST)
    public int updateCar(@RequestBody CarEntity carEntity) {
        return carService.updateCar(carEntity);
    }

    @RequestMapping(value = "/getCar", method = RequestMethod.GET)
    public CarEntity getCar(@RequestParam(value = "id") Long id) {
        return carService.getCar(id);
    }

    @RequestMapping(value = "/listCars", method = RequestMethod.GET)
    public List<CarEntity> listCars() {
        return carService.listCars();
    }

    @RequestMapping(value = "/listPageCars", method = RequestMethod.GET)
    public PageInfo<CarEntity> listPageCars() {
        return carService.listPageCars();
    }
}
