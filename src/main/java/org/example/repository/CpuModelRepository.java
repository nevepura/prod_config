package org.example.repository;

import org.example.entity.CpuModel;
import org.example.entity.MoboModel;
import org.example.entity.RamModel;
import org.example.enums.ComponentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CpuModelRepository extends JpaRepository<CpuModel, Integer> {

    List<CpuModel> fetchByComponentTypes(List<ComponentType> types);
}