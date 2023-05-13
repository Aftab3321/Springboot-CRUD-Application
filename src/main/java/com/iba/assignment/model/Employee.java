package com.iba.assignment.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Table(name="Employee")
@Entity
@Getter
@Setter
@ToString
public class Employee {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String email;
    private String dob;
    private Number mobile;
}
