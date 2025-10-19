package com.atalaykaan.spring_boot_mongodb.service;

import com.atalaykaan.spring_boot_mongodb.dto.StudentDto;
import com.atalaykaan.spring_boot_mongodb.model.Student;
import com.atalaykaan.spring_boot_mongodb.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentDto createStudent(StudentDto studentDto) {

        studentRepository.save(Student.builder()
                .id(studentDto.getId())
                .name(studentDto.getName())
                .address(studentDto.getAddress())
                .build());

        return studentDto;
    }
}
