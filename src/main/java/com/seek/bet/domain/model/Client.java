package com.seek.bet.domain.model;

import java.time.LocalDate ;

public class Client {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate  birthDate;

    public Client(Long id, String firstName, String lastName, Integer age, LocalDate  birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthDate = birthDate;
    }

    // Getters and setters
    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public LocalDate  getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate  birthDate) { this.birthDate = birthDate; }
}
