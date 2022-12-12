package com.krug.dataclient.service;

import com.krug.dataclient.entity.Exams;

import java.util.List;
import java.util.Optional;

public interface ExamService {
    List<Exams> listar();

    Optional<Exams> obtenerExamPorUsuarios(Integer id);

    Optional<Exams> obtenerExamPorUsuarioId(Integer id);

    Exams guardar(Exams exams);

    void eliminar(Integer id);

}
