package com.developers.PinksiClub.model;
import com.developers.PinksiClub.enumeration.TableTennisType;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
@Data
public class TableTennisRegistration {

    private Long id;
    private Customer customer;
    private LocalDateTime registrationTime;
    private TableTennisType tableTennisType;

    public TableTennisRegistration(Long id, Customer customer, LocalDateTime registrationTime, TableTennisType tableTennisType) {
        this.id = id;
        this.customer = customer;
        this.registrationTime = registrationTime;
        this.tableTennisType = tableTennisType;
    }
}
