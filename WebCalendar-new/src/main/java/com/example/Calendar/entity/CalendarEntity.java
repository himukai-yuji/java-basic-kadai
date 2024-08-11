package com.example.Calendar.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "calender_table")
@Data
public class CalendarEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;
	
    @Column(name = "DATE")
    private LocalDate DATE;

    @Column(name = "TODO")
    private String TODO;
    
    @Column(name = "MEMO")
    private String MEMO;

}