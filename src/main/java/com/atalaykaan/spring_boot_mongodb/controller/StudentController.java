package com.atalaykaan.spring_boot_mongodb.controller;

import com.atalaykaan.spring_boot_mongodb.dto.StudentDto;
import com.atalaykaan.spring_boot_mongodb.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(studentDto.getId())
                .toUri();

        return ResponseEntity.created(location).body(studentService.createStudent(studentDto));
    }

    @PostMapping("/list")
    public ResponseEntity<List<StudentDto>> createMultipleStudents(@RequestBody List<StudentDto> studentDtoList) {

        return ResponseEntity.ok(studentService.createMultipleStudents(studentDtoList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> findStudentById(@PathVariable Long id) {

        return ResponseEntity.ok(studentService.findStudentById(id));
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> findAllStudents() {

        return ResponseEntity.ok(studentService.findAllStudents());
    }

    @GetMapping("/find-max")
    public ResponseEntity<Integer> findStudentWithHighestMark() {

        return ResponseEntity.ok(studentService.findHighestMark());
    }

    @GetMapping("/find-min")
    public ResponseEntity<Integer> findStudentWithLowestMark() {

        return ResponseEntity.ok(studentService.findLowestMark());
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto) {

        return ResponseEntity.ok(studentService.updateStudent(id, studentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id) {

        studentService.deleteStudentById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllStudents() {

        studentService.deleteAllStudents();

        return ResponseEntity.noContent().build();
    }
}
