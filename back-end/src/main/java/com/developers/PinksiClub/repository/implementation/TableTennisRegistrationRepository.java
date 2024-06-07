package com.developers.PinksiClub.repository.implementation;

import com.developers.PinksiClub.model.TableTennisRegistration;

import java.util.List;

public interface TableTennisRegistrationRepository {
    TableTennisRegistration save(TableTennisRegistration registration);
    TableTennisRegistration findById(Long id);
    List<TableTennisRegistration> findAll();
    void delete(Long id);
}
