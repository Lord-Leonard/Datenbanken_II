package com.company.blatt_3.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Massnahme implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_number", nullable = false)
    protected Problem problem;



    @Id
    @Column(nullable = false)
    protected Long massnahmeNummer;

    @Column
    protected String title;

    @Column
    protected String beschreibung;

    @Column
    protected int Status;

}
