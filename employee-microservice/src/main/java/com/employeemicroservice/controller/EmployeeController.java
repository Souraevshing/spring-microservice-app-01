package com.employeemicroservice.controller;

import com.employeemicroservice.dto.ApiResponseDto;
import com.employeemicroservice.dto.EmployeeDto;
import com.employeemicroservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employee")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping
    @Operation( summary = "Create employee", description = "Returns employee as response")
    @ApiResponses( value = {
            @ApiResponse( responseCode = "201", description = "Employee created successfully", useReturnTypeSchema = true),
            @ApiResponse( responseCode = "404", description = "Not found", useReturnTypeSchema = true )
    })
    public ResponseEntity<EmployeeDto>saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);
    }

    @Operation( summary = "Get employee by id", description = "Returns employee as response")
    @ApiResponses( value = {
            @ApiResponse( responseCode = "201", description = "Employee retrieved successfully", useReturnTypeSchema = true),
            @ApiResponse( responseCode = "404", description = "Not found", useReturnTypeSchema = true )
    })
    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        return new ResponseEntity<>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    }
}
