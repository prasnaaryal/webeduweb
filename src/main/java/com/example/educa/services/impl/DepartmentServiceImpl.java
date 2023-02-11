package com.example.educa.services.impl;

import com.example.educa.Entity.Department;


import com.example.educa.repo.DepartmentRepository;
import com.example.educa.services.DepartmentService;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        super();
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }




    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }


    }
