package org.example.entity;

import lombok.Data;
import org.example.enums.ComponentCategory;
import org.example.enums.ComponentType;
import org.example.enums.ConstraintType;

@Data
public class Constraint {
    private int id;
    private int moboId;
    private ConstraintType constraintType;
    private ComponentCategory componentCategory;
    private ComponentType componentType;
    private String description;

    private int quantityMin;
    private int quantityMax;


}
