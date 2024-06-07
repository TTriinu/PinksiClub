package com.developers.PinksiClub.service.implementation;

import com.developers.PinksiClub.service.Customer;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Getter
@JsonInclude(NON_DEFAULT)
public class CustomerImpl implements Customer {
    private Long id;
    private String name;
    private String email;

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getEmail() {
        return "";
    }

    @Override
    public void setId(Long id) {

    }

    @Override
    public void put(Long id, Customer customer) {

    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void setEmail(String email) {

    }

    public CustomerImpl(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

}
