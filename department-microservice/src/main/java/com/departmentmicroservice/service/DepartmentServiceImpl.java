package com.departmentmicroservice.service;

import com.departmentmicroservice.dto.DepartmentDto;
import com.departmentmicroservice.entity.Department;
import com.departmentmicroservice.mapper.DepartmentMapper;
import com.departmentmicroservice.repository.DepartmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        List<Department> departments = departmentRepository
                .findAll();

        List<DepartmentDto> departmentDto = departments
                .stream()
                .map(DepartmentMapper::convertToDto)
                .toList();

        return ResponseEntity.ok(departmentDto);
    }

    @Override
    public ResponseEntity<Void> deleteDepartmentById(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        if(department != null) {
            departmentRepository.delete(department);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
