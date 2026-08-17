package com.example.demo.auth.User;

import com.example.demo.Entity.Entry;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Или JOINED / TABLE_PER_CLASS
@DiscriminatorColumn(name = "User_type")
@Entity
public abstract class User extends Entry {
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "age", nullable = false)
    private int age;
    @Email
    private String email;
}
