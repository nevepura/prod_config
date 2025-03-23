package org.example.api.response;

import lombok.Builder;
import lombok.Data;
import org.example.entity.CpuModel;
import org.example.entity.RamModel;

import java.util.List;

@Data
@Builder
public class FetchMandatoryComponentsResponse {
    List<CpuModel> cpuModels;
    List<RamModel> ramModels;
}
