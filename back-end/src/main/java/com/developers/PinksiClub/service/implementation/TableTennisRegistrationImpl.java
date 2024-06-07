package com.developers.PinksiClub.service.implementation;

import com.developers.PinksiClub.service.Customer;
import com.developers.PinksiClub.service.TableTennisRegistration;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;


import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Getter
@JsonInclude(NON_DEFAULT)
public class TableTennisRegistrationImpl implements TableTennisRegistration {
    private Long id;
    private Customer customer;
    private LocalDateTime registrationTime;
    private String tableTennisType;

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public Customer getCustomer() {
        return null;
    }

    @Override
    public LocalDateTime getRegistrationTime() {
        return null;
    }

    @Override
    public String getTableTennisType() {
        return "";
    }
}
