package com.becode.cogip.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String vatNumber;
    private String type; // You can define company types as needed

    // Define relationships (e.g., with invoices, contacts)
    @OneToMany(mappedBy = "company")
    private List<Invoice> invoices;

    @OneToMany(mappedBy = "company")
    private List<Contact> contacts;

    // Constructors, getters, and setters
}
