package com.departmentmicroservice.controller;

import com.departmentmicroservice.dto.DepartmentDto;
import com.departmentmicroservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/department")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @Operation( summary = "Create department", description = "Returns department as response")
    @ApiResponses( value = {
            @ApiResponse( responseCode = "201", description = "Department created successfully", useReturnTypeSchema = true),
            @ApiResponse( responseCode = "404", description = "Not found", useReturnTypeSchema = true )
    })
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.saveDepartment(departmentDto), HttpStatus.CREATED);
    }

    @Operation( summary = "Get department by id", description = "Returns single department by id as response")
    @ApiResponses( value = {
            @ApiResponse( responseCode = "200", description = "Department retrieved successfully", useReturnTypeSchema = true ),
            @ApiResponse( responseCode = "404", description = "Not found", useReturnTypeSchema = true )
    })
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("department-code") String departmentCode) {
        return new ResponseEntity<>(departmentService.getDepartmentById(departmentCode), HttpStatus.OK);
    }

    @Operation( summary = "Get all departments", description = "Returns all department as response")
    @ApiResponses( value = {
            @ApiResponse( responseCode = "200", description = "Department retrieved successfully", useReturnTypeSchema = true ),
            @ApiResponse( responseCode = "404", description = "Not found", useReturnTypeSchema = true )
    })
    @GetMapping()
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        List<DepartmentDto> departments = departmentService.getAllDepartments().getBody();
        if(departments==null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(departments);
    }

    @Operation( summary = "Delete department by id", description = "Returns deleted department")
    @ApiResponses( value = {
            @ApiResponse( responseCode = "200", description = "Department deleted successfully", useReturnTypeSchema = true ),
            @ApiResponse( responseCode = "404", description = "Not found", useReturnTypeSchema = true )
    })
    @DeleteMapping("{department-code}")
    public ResponseEntity<Void> deleteDepartmentById(@PathVariable("department-code") String departmentCode) {
        ResponseEntity<Void> response = departmentService.deleteDepartmentById(departmentCode);
        if(response.getStatusCode()==HttpStatus.NO_CONTENT) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
