package com.departmentmicroservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "Response for department"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Long id;
    @Schema( name = "departmentName", description = "Department name" )
    private String departmentName;
    @Schema( name="departmentDescription", description = "Department description" )
    private String departmentDescription;
    @Schema( name="departmentCode", description = "Department code" )
    private String departmentCode;
}
