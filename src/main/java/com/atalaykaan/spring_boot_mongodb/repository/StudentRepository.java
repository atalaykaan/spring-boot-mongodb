package com.atalaykaan.spring_boot_mongodb.repository;

import com.atalaykaan.spring_boot_mongodb.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, Long> {
}
