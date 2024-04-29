package com.employeemicroservice.mapper;

import com.employeemicroservice.dto.EmployeeDto;
import com.employeemicroservice.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto convertToDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode(),
                employee.getOrganisationCode()
        );
    }

    public static Employee convertToJpa(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode(),
                employeeDto.getOrganisationCode()
        );
    }
}
