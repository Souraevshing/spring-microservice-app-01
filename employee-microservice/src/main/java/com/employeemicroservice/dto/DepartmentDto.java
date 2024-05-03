package com.employeemicroservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Long id;
    @Schema( name = "departmentName", description = "departmentName" )
    private String departmentName;
    @Schema( name = "departmentDescription", description = "departmentDescription" )
    private String departmentDescription;
    @Schema( name = "departmentCode", description = "departmentCode" )
    private String departmentCode;
}
