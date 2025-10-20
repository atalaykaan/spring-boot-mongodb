package com.atalaykaan.spring_boot_mongodb.repository;

import com.atalaykaan.spring_boot_mongodb.model.Student;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, Long> {

    @Aggregation(pipeline = { "{$group: { _id: '', total: {$max: $mark}}}" })
    public Integer max();

    @Aggregation(pipeline = {"{$group: { _id: '', total: {$min: $mark}}} "})
    public Integer min();
}
