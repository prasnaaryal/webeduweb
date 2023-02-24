package com.example.educa;

import com.example.educa.Entity.User;
import com.example.educa.repo.UserRepo;
import org.junit.jupiter.api.*;
import org.assertj.core.api.Assertions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryText {
    @Autowired
    private UserRepo userRepo;

    @Test
    @Order(1)
    public void saveUserTest(){
        //to use user.builder @builder annotation is required in the builder class
        User user=User.builder()
                .fullName("prasna")
                .email("prasna@gmail.com")
                .build();
        userRepo.save(user);
        Assertions.assertThat(user.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getUserTest(){
        User userCreated = userRepo.findById(1).get();
        Assertions.assertThat(userCreated.getId()).isEqualTo(1);
    }



        @Test
        @Order(3)
        public void getListOfUserTest(){
            List<User> users=userRepo.findAll();
            Assertions.assertThat(users.size()).isGreaterThan(0);
        }

        @Test
        @Order(4)
        @Rollback(value = false)
        public void updateUserTest(){
            User user=userRepo.findById(1).get();
            user.setFullName("Prasna aryal");
            User userUpdated=userRepo.save(user);

            Assertions.assertThat(userUpdated.getFullName()).isEqualTo("Prasna Aryal");
        }



    }
//
//    @Test
//    @Order(3)
//    public void




