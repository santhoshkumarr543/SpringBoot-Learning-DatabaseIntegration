package com.example.JPADemo.repository;

import com.example.JPADemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
    //findbytechnology is created bassed on "technology" property in "Student" class
    //If incase any doubt refer - "YT-CONQUER VICTORY - 5:15(Declarative method)"
    List<Student> findByTechnology(String technology);

    @Query(nativeQuery = true,
    value = "select * from student where gender=:gender and technology =:technology")
    List<Student> findByGenderAndTechnology(@Param("gender") String gender,
                                            @Param("technology") String technology);
}
