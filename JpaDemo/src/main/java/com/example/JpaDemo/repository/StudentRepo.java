package com.example.JpaDemo.repository;

import com.example.JpaDemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    List<Student> findByTechnology(String technology);

    @Query(nativeQuery = true,
    value = "SELECT * FROM Student WHERE gender =: ?1 and technology =: ?2")
    List<Student> findByGenderAndTechnology(@Param("gender")String gender, @Param("technology")String technology);
}
