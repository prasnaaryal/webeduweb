package com.example.educa.services;

import com.example.educa.Entity.Department;



import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartment();

    Department saveDepartment(Department department);

    Department getDepartmentById(Long id);

    Department updateDepartment(Department department);

    void deleteDepartmentById(Long id);
}
