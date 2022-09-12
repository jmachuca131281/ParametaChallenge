package com.example.parameta;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class EmployeeEntity {
    @Id
    @Column(unique = true, nullable = false)
    private String id_document;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String last_name;
    @Column(nullable = false)
    private String document_type;
    @Column(nullable = false)
    public LocalDate birth_date;
    @Column(nullable = false)
    private LocalDate vinculation_company;
    @Column(nullable = false)
    private String job_position;
    @Column(nullable = false)
    private Double wage;

    public String getIdDocument() {
        return id_document;
    }

    public void setIdDocument(String id_document) {
        this.id_document = id_document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getDocumentType() {
        return document_type;
    }

    public void setDocumentType(String document_type) {
        this.document_type = document_type;
    }

    public LocalDate getBirthDate() {
        return birth_date;
    }

    public void setBirthDate(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public LocalDate getVinculationCompany() {
        return vinculation_company;
    }

    public void setVinculationCompany(LocalDate vinculation_company) {
        this.vinculation_company = vinculation_company;
    }

    public String getJobPosition() {
        return job_position;
    }

    public void setJobPosition(String job_position) {
        this.job_position = job_position;
    }

    public Double getWage() {
        return wage;
    }

    public void setWage(Double wage) {
        this.wage = wage;
    }
}