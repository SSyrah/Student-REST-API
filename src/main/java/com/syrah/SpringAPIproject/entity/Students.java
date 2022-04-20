package com.syrah.SpringAPIproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;

    @NotBlank(message = "Please Add Student First Name")
    private String studentFirstName;

    @NotBlank(message = "Please Add Student Last Name")
    private String studentLastName;

    private String studentAddress;
    private String className;
    private Long coursesAccomplished;

    @PositiveOrZero
    private Long studentPoints;

}
