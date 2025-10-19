package com.atalaykaan.spring_boot_mongodb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {

    private Long id;

    private String name;

    private String address;
}
