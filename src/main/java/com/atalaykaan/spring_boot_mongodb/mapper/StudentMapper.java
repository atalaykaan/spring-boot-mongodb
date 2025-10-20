package com.atalaykaan.spring_boot_mongodb.mapper;

import com.atalaykaan.spring_boot_mongodb.dto.StudentDto;
import com.atalaykaan.spring_boot_mongodb.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toStudent(StudentDto studentDto);

    StudentDto toDto(Student student);
}
