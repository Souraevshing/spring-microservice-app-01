package com.departmentmicroservice.mapper;

import com.departmentmicroservice.dto.DepartmentDto;
import com.departmentmicroservice.entity.Department;

public class DepartmentMapper {
    public static DepartmentDto convertToDto(Department department) {
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
    }

    public static Department convertToJpa(DepartmentDto departmentDto) {
        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
    }
}
