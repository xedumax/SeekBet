package com.seek.bet.infraestructure.entities;

import com.seek.bet.domain.model.Client;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate birthDate;

    public ClientEntity() {
    }

    public ClientEntity(Long id, String firstName, String lastName, Integer age, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthDate = birthDate;
    }

    public static ClientEntity fromDomainModel(Client client) {
        return new ClientEntity(client.getId(), client.getFirstName(), client.getLastName(), client.getAge(), client.getBirthDate());
    }

    public Client toDomainModel() {
        return new Client(id, firstName, lastName, age, birthDate);
    }


    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

}
