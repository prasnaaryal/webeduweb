//package com.example.educa.pojo;
//
//import com.example.educa.Entity.Student;
//import com.example.educa.Entity.User;
//import jakarta.validation.constraints.NotEmpty;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//
//
//
//
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//
////for validation and data
//public class StudentPojo {
//
//    private Integer id;
//
//    @NotEmpty(message = "Email can't be empty")
//    private String email;
//
//    @NotEmpty(message = "Full name can't be empty")
//    private String firstName;
//
//    @NotEmpty(message = "Full name can't be empty")
//    private String lastName;
//
////    @NotEmpty(message = "Mobile Number can't be empty")
////    private String mobile_no;
//
//    @NotEmpty(message = "Address can't be empty")
//    private String address;
//
//    @NotEmpty(message = "Department can't be empty")
//    private String department;
//
////    private MultipartFile image;
//
//    public StudentPojo(Student student){
//        this.id=students.getId();
//        this.email=students.getEmail();
//        this.firstname=students.getFullName();
////        this.mobile_no=user.getMobileNo();
//        this.password=students.getPassword();
//    }
//}
