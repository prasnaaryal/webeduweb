package com.example.educa;

import com.example.educa.Entity.Department;
import com.example.educa.Entity.Student;
import com.example.educa.repo.DepartmentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class DepartmentRepo {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    @Order(1)
    public void saveDepartmentTest(){
        Department department= Department.builder()
                .Name("computing")
                .Credit(" 80")
                .build();

        departmentRepository.save(department);
        Assertions.assertThat(department.getId()).isGreaterThan(0);
}}
