package com.developers.PinksiClub.service;

public interface Customer {
    Long getId();
    String getName();
    String getEmail();

    void setId(Long id);

    void put(Long id, Customer customer);

    void setName(String name);

    void setEmail(String email);
}
