package com.seek.bet.domain.model;
import java.time.LocalDate;
public class ClientWithEvent {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate birthDate;
    private LocalDate estimatedEventDate;

    public ClientWithEvent(Long id, String firstName, String lastName, Integer age, LocalDate birthDate, LocalDate estimatedEventDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthDate = birthDate;
        this.estimatedEventDate = estimatedEventDate;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public Integer getAge() { return age; }
    public LocalDate getBirthDate() { return birthDate; }
    public LocalDate getEstimatedEventDate() { return estimatedEventDate; }
}