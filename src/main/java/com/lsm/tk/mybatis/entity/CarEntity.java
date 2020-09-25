package com.lsm.tk.mybatis.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "car")
public class CarEntity {
    @Id
    /**
     * 主键回写
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String brand;
}
