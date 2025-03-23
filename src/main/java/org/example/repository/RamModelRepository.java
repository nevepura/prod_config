package org.example.repository;

import org.example.entity.CpuModel;
import org.example.entity.MoboModel;
import org.example.entity.RamModel;
import org.example.enums.ComponentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * It would be a JPA repository
 */
@Repository
public interface RamModelRepository extends JpaRepository<RamModel, Integer> {

    List<RamModel> fetchByComponentTypes(List<ComponentType> types);
}
