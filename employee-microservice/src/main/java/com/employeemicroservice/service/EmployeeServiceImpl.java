package com.employeemicroservice.service;

import com.employeemicroservice.dto.ApiResponseDto;
import com.employeemicroservice.dto.DepartmentDto;
import com.employeemicroservice.dto.EmployeeDto;
import com.employeemicroservice.dto.OrganisationDto;
import com.employeemicroservice.entity.Employee;
import com.employeemicroservice.mapper.EmployeeMapper;
import com.employeemicroservice.repository.EmployeeRepository;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ApiClient apiClient;
    private final WebClient webClient;
    private final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ApiClient apiClient, WebClient webClient) {
        this.employeeRepository = employeeRepository;
        this.apiClient = apiClient;
        this.webClient = webClient;
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.convertToJpa(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.convertToDto(savedEmployee);
    }

    @Retry( name = "${spring.application.name}", fallbackMethod = "getDefaultEmployee")
    @Override
    public ApiResponseDto getEmployeeById(Long employeeId) {
        LOGGER.info("inside getEmployeeById()");

        Employee employee = employeeRepository.findById(employeeId).orElseThrow();

        //DepartmentDto departmentDto = apiClient.getDepartmentById(employee.getDepartmentCode());
        DepartmentDto departmentDto = webClient
                .get()
                .uri("http://localhost:8080/api/v1/department/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

        OrganisationDto organisationDto = webClient
                .get()
                .uri("http://localhost:8082/api/v1/organisation/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(OrganisationDto.class)
                .block();

        EmployeeDto employeeDto = EmployeeMapper.convertToDto(employee);

        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        apiResponseDto.setOrganisation(organisationDto);

        return apiResponseDto;
    }

    public ApiResponseDto getDefaultEmployee(Long employeeId) {
        LOGGER.info("inside getDefaultEmployee()");

        Employee employee = employeeRepository.findById(employeeId).orElseThrow();

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("Department name not found!");
        departmentDto.setDepartmentDescription("Department description not found!");
        departmentDto.setDepartmentCode("Department code not found!");

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode(),
                employee.getOrganisationCode()
        );

        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
}
