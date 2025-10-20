package com.atalaykaan.spring_boot_mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Transient
    public static final String SEQUENCE_NAME = "students_sequence";

    @Id
    private Long id;

    private String name;

    private Integer mark;

    private String address;
}
