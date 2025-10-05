package com.satyam.Spring_Sec_Proj.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    private int id;
    @Column(name = "username")
    private String userName;
    private String password;
}
