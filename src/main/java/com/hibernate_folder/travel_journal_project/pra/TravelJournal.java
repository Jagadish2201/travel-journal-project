package com.hibernate_folder.travel_journal_project.pra;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

// Marks this class as a Hibernate Entity
@Entity

// Maps this class to the database table
@Table(name = "journal_table")

// Generates getters, setters, toString(), etc.

@Data
public class TravelJournal {

    // Primary Key
    @Id

    // Auto-generate ID value (currently disabled)
    // @GeneratedValue(strategy = GenerationType.AUTO)

    // Maps field to journalId column
    @Column(name = "journalId")
    private int id;

    // Maps field to destination column
    @Column(name = "destination")
    private String destination;

    // Maps field to travelerName column
    @Column(name = "travelerName")
    private String name;

    // Maps field to travelDate column
    @Column(name = "travelDate")
    private LocalDate date;

    // Maps field to budget column
    @Column(name = "budget")
    private double budget;
}