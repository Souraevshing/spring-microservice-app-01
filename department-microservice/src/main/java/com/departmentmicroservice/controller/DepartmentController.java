package com.departmentmicroservice.controller;

import com.departmentmicroservice.dto.DepartmentDto;
import com.departmentmicroservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/department")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        return new ResponseEntity<>(departmentService.saveDepartment(departmentDto), HttpStatus.CREATED);
    }

    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("department-code") String departmentCode) {
        return new ResponseEntity<>(departmentService.getDepartmentById(departmentCode), HttpStatus.OK);
    }
}
