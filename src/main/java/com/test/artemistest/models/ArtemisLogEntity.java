package com.test.artemistest.models;

import liquibase.pro.packaged.S;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "artemisLog")
public class ArtemisLogEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotNull
    private String message;

    @NotNull
    private Date date;

    @NotNull
    private String destinations;

    public ArtemisLogEntity(String message, String destinations) {
        this.date = new Date();
        this.message = message;
        this.destinations = destinations;
    }
}
