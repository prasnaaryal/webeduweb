package com.example.educa.repo;

import com.example.educa.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
//    @Query(value="select s.id, s.firstname, d.department from students s Inner JOIN department d ON s.department=d.id", nativeQuery=true)
//    List<Object[]> findByEmail(String email);
@Query (value = "select * from students where email=?1", nativeQuery = true)
Optional<Student> findByEmail(String email);

}
