package com.departmentmicroservice.service;

import com.departmentmicroservice.dto.DepartmentDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentById(String departmentCode);
    ResponseEntity<List<DepartmentDto>> getAllDepartments();
    ResponseEntity<Void> deleteDepartmentById(String departmentCode);
}
