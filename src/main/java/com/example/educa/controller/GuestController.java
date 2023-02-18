package com.example.educa.controller;


import com.example.educa.services.DepartmentService;
import com.example.educa.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@AllArgsConstructor
@RequestMapping("/geust")
public class GuestController {

    private StudentService studentService;
    private DepartmentService departmentService;





        @GetMapping("/dashboard")
        public String getPage(Model model){
            model.addAttribute("depList",departmentService.getAllDepartment());

            model.addAttribute("studentList", studentService.getAllStudents());
            return "guestdashboard";
        }



}
