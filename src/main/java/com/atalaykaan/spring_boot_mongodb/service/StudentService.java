package com.atalaykaan.spring_boot_mongodb.service;

import com.atalaykaan.spring_boot_mongodb.dto.StudentDto;
import com.atalaykaan.spring_boot_mongodb.exception.StudentNotFoundException;
import com.atalaykaan.spring_boot_mongodb.mapper.StudentMapper;
import com.atalaykaan.spring_boot_mongodb.model.Student;
import com.atalaykaan.spring_boot_mongodb.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;

    private final SequenceGeneratorService sequenceGeneratorService;

    public StudentDto createStudent(StudentDto studentDto) {

        Student student = studentRepository.save(Student.builder()
                .id(sequenceGeneratorService.generateSequence(Student.SEQUENCE_NAME))
                .name(studentDto.getName())
                .mark(studentDto.getMark())
                .address(studentDto.getAddress())
                .build());

        return studentMapper.toDto(student);
    }

    public List<StudentDto> createMultipleStudents(List<StudentDto> studentDtoList) {

        return studentDtoList.stream().map(this::createStudent).toList();
    }

    public StudentDto findStudentById(Long id) {

        return studentRepository.findById(id)
                .map(studentMapper::toDto)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));

    }

    public List<StudentDto> findAllStudents() {

        return Optional.of(studentRepository.findAll())
                .filter(list -> !list.isEmpty())
                .map(students -> students.stream().map(studentMapper::toDto).toList())
                .orElseThrow(() -> new StudentNotFoundException("No students were found"));
    }

    public Integer findHighestMark() {

        return studentRepository.max();
    }

    public Integer findLowestMark() {

        return studentRepository.min();
    }

    public StudentDto updateStudent(Long id, StudentDto studentDto) {

        Student foundStudent = studentRepository.findById(id)
                .map(student -> {
                    student.setName(studentDto.getName());
                    student.setAddress(studentDto.getAddress());
                    return student;
                })
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));

        return studentMapper.toDto(studentRepository.save(foundStudent));
    }

    public void deleteStudentById(Long id) {

        studentRepository.deleteById(studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"))
                .getId());
    }

    public void deleteAllStudents() {

        if(studentRepository.findAll().isEmpty()) {

            throw new StudentNotFoundException("No students were found");
        }

        studentRepository.deleteAll();
    }
}
