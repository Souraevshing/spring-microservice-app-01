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
public class ApiResponseDto {
    @Schema( name = "employee", description = "employee" )
    private EmployeeDto employee;
    @Schema( name = "department", description = "department" )
    private DepartmentDto department;
    @Schema( name = "organisation", description = "organisation" )
    private OrganisationDto organisation;
}
