package com.atalaykaan.spring_boot_mongodb.controller;

import com.atalaykaan.spring_boot_mongodb.dto.StudentDto;
import com.atalaykaan.spring_boot_mongodb.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(studentDto.getId())
                .toUri();

        return ResponseEntity.created(location).body(studentService.createStudent(studentDto));
    }
}
