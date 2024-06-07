package com.developers.PinksiClub.model;
import lombok.Data;
import lombok.Getter;


@Getter
@Data
public class Customer {

    private Long id;
    private String name;
    private String email;

    public Customer(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
