package com.example.shipreservationsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "user-credentials")
public class UserCredentials {


    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String passWord;

    public UserCredentials(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
}
