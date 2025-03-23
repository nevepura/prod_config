package org.example.entity;

import lombok.Data;
import org.example.enums.ComponentType;

@Data
public class RamModel {
    private int id;
    private String name;
    private ComponentType componentType;
}