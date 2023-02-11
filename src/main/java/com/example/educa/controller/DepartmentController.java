package com.example.educa.controller;



import com.example.educa.Entity.Department;

import com.example.educa.services.DepartmentService;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DepartmentController {

    private DepartmentService departmentService;

    public  DepartmentController(DepartmentService departmentService) {
        super();
        this.departmentService = departmentService;
    }

    // handler method to handle list mwni and return mode and view
    @GetMapping("/departments")
    public String listDepartment(Model model) {
        model.addAttribute("department", departmentService.getAllDepartment());
        return "departments";
    }

    @GetMapping("/departments/new")
    public String createDepartmentForm(Model model) {

        // create menu object to hold mwnu form data
        Department department = new Department();
        model.addAttribute("department", department);
        return "create_department";

    }

    @PostMapping("/departments")
    public String saveDepartment(@ModelAttribute("department") Department department) {
        departmentService.saveDepartment(department);
        return "redirect:/departments";
    }

    @GetMapping("/departments/edit/{id}")
    public String editDepartmentForm(@PathVariable Long id, Model model) {
        model.addAttribute("department", departmentService.getDepartmentById(id));
        return "edit_department";
    }

    @PostMapping("/departments/{id}")
    public String updateDepartment(@PathVariable Long id,
                                @ModelAttribute("department") Department department,
                                Model model) {

        // get menu from database by id
        Department existingDepartment = departmentService.getDepartmentById(id);
        existingDepartment.setId(id);

        existingDepartment.setName(department.getName());
        existingDepartment.setName(department.getCredit());

        // save updated menu object
        departmentService.updateDepartment(existingDepartment);
        return "redirect:/departments";
    }

    // handler method to handle delete menu request

    @GetMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartmentById(id);
        return "redirect:/departments";
    }

}
