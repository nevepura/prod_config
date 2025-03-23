package org.example.repository;

import org.example.entity.Constraint;
import org.example.entity.Mobo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConstraintRepository extends JpaRepository<Constraint, Integer> {

    List<Constraint> fetchAll();

    List<Constraint> fetchConstraints(Mobo mobo);
}