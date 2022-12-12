package com.krug.dataclient.service.impl;

import com.krug.dataclient.entity.Exams;
import com.krug.dataclient.repository.ExamsRepository;
import com.krug.dataclient.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamsRepository examsRepository;

    @Override
    public List<Exams> listar() {
        return (List<Exams>) examsRepository.findAll();
    }

    @Override
    public Optional<Exams> obtenerExamPorUsuarios(Integer id) {
        return examsRepository.findById(id);
    }

    @Override
    public Optional<Exams> obtenerExamPorUsuarioId(Integer id) {
        return Optional.empty();
    }

    @Override
    public Exams guardar(Exams exams) {
        return examsRepository.save(exams);
    }

    @Override
    public void eliminar(Integer id) {

    }
}
