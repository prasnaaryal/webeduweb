package com.example.educa.repo;
import com.example.educa.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {


    @Query(value = "select * from users where email=?1", nativeQuery = true)
    Optional<User> findByEmail(String email);

    @Modifying
    @Query(value = "insert into users_roles(user_id,role_id) values(?1,2)",nativeQuery = true)
    void insertUserRole(Integer u_id);
}