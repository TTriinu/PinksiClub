package com.developers.PinksiClub.service;

import java.time.LocalDateTime;

public interface TableTennisRegistration {
    Long getId();
    Customer getCustomer();
    LocalDateTime getRegistrationTime();
    String getTableTennisType();
}

