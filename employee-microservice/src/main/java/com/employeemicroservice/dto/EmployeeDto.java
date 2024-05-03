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
public class EmployeeDto {
    private Long id;
    @Schema( name = "firstName", description = "firstName" )
    private String firstName;
    @Schema( name = "lastName", description = "lastName" )
    private String lastName;
    @Schema( name = "email", description = "email" )
    private String email;
    @Schema( name = "departmentCode", description = "departmentCode" )
    private String departmentCode;
    @Schema( name = "organisationCode", description = "organisationCode" )
    private String organisationCode;
}
