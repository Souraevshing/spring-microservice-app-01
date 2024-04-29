package com.employeemicroservice.service;

import com.employeemicroservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient( name = "department-microservice" )
public interface ApiClient {
    @GetMapping("api/v1/department/{department-code}")
    DepartmentDto getDepartmentById(@PathVariable("department-code") String departmentCode);
}
