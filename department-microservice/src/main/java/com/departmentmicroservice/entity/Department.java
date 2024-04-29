package com.departmentmicroservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table( name = "department_tab" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private  Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
