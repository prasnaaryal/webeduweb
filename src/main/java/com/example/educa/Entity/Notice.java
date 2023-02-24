package com.example.educa.Entity;



import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Builder
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "notices")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "notice_name", nullable = false)
    private String noticeName;



    public Notice() {

    }

    public Notice(String noticeName) {
        super();
        this.noticeName = noticeName;

    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNoticeName() {
        return noticeName;
    }
    public void setNoticeName(String noticeName){
        this.noticeName = noticeName;
    }


//    @OneToMany(mappedBy = "student", orphanRemoval = true, cascade = CascadeType.PERSIST)
//    List<Department> departments = new ArrayList<Department>();


}
