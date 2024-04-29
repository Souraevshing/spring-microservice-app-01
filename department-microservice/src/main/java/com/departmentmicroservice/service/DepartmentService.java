package com.departmentmicroservice.service;

import com.departmentmicroservice.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentById(String departmentCode);
}
