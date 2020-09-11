package com.lsm.tk.mybatis.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "car")
public class CarEntity {
    @Id
    private Long id;
    @Column
    private String brand;
}
