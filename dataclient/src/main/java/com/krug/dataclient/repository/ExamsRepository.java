package com.krug.dataclient.repository;

import com.krug.dataclient.entity.Exams;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamsRepository extends JpaRepository<Exams, Integer> {

    List<Exams> findExamsByUsuarioId(Integer id);
}
