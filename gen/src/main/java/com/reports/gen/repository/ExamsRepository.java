package com.reports.gen.repository;

import com.reports.gen.entity.Exams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExamsRepository extends JpaRepository<Exams, Integer> {

    @Query(value="select * from exams a where a.usuarioId = :value", nativeQuery=true)
    List<Exams> usuarioporid(String value);

    List<Exams> findExamsByUsuarioId(Integer id);
}
