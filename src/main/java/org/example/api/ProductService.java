package org.example.api;

import org.example.api.response.FetchMandatoryComponentsResponse;
import org.example.entity.*;
import org.example.enums.ComponentCategory;
import org.example.enums.ComponentType;
import org.example.repository.ConstraintRepository;
import org.example.repository.CpuModelRepository;
import org.example.repository.RamModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductService {


    @Autowired
    private RamModelRepository ramModelRepository;

    @Autowired
    private CpuModelRepository cpuModelRepository;

    @Autowired
    private ConstraintRepository constraintRepository;

    /*
        Given a Mobo, in order do the following:
        fetch constraints of a mobo in DB
        for RAM:
            filter constraints with component_category = RAM
            then get the component type
            then get from RAM model filtering by type

        for GPU and any other component: do the same
     */
    public FetchMandatoryComponentsResponse fetchMandatoryComponents(Mobo mobo){
        List<Constraint> constraints = constraintRepository.fetchConstraints(mobo);

        // RAM
        List<ComponentType> ramComponentTypes = constraints.stream()
            .filter(con -> ComponentCategory.RAM.equals(con.getComponentCategory()))
            .map(Constraint::getComponentType)
            .collect(Collectors.toList());

        List<RamModel> ramModels = ramModelRepository.fetchByComponentTypes(ramComponentTypes);

        // CPU
        List<ComponentType> cpuComponentTypes = constraints.stream()
            .filter(con -> ComponentCategory.CPU.equals(con.getComponentCategory()))
            .map(Constraint::getComponentType)
            .collect(Collectors.toList());

        List<CpuModel> cpuModels = cpuModelRepository.fetchByComponentTypes(cpuComponentTypes);

        // Put all the retrieved in response
        return FetchMandatoryComponentsResponse.builder()
            .ramModels(ramModels)
            .cpuModels(cpuModels)
            .build();
    }

}
