package com.departmentmicroservice.service;

import com.departmentmicroservice.dto.DepartmentDto;
import com.departmentmicroservice.entity.Department;
import com.departmentmicroservice.mapper.DepartmentMapper;
import com.departmentmicroservice.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.convertToJpa(departmentDto);

        Department savedDepartment = departmentRepository
                .save(department);

        return DepartmentMapper.convertToDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        return DepartmentMapper.convertToDto(department);
    }
}
