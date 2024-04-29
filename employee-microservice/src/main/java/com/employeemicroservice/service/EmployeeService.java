package com.employeemicroservice.service;

import com.employeemicroservice.dto.ApiResponseDto;
import com.employeemicroservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    ApiResponseDto getEmployeeById(Long employeeId);
}
