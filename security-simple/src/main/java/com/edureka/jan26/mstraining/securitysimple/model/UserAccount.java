package com.edureka.jan26.mstraining.securitysimple.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
public class UserAccount{


    public UserAccount(){

    }

    public UserAccount(String userName, String password, boolean active){
        this.userName = userName;
        this.password = password;
        this.active = active;
    }

    @Id
    @GeneratedValue
    Long id;
    String userName;
    String password;
    boolean active;

}
