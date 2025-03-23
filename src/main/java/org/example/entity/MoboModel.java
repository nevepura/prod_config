package org.example.entity;

import lombok.Data;
import org.example.enums.ComponentType;

import java.math.BigDecimal;

@Data
public class MoboModel {
    private int id;
    private String name;
    private String description;
    private BigDecimal price;


}
