package com.krug.dataclient.controller;

import com.krug.dataclient.entity.Exams;
import com.krug.dataclient.entity.ExamsDTO;
import com.krug.dataclient.exceptions.ResourceNotFoundException;
import com.krug.dataclient.repository.ExamsRepository;
import com.krug.dataclient.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ExamsController {

    @Autowired
    private ExamService examService;
    @Autowired
    private ExamsRepository examsRepository;

    @GetMapping("/private/historial/{id}")
    public List<Exams> historialMed(@PathVariable Integer id){
        List<Exams> exams = examsRepository.findExamsByUsuarioId(id);
        if (!exams.isEmpty()){
            return examsRepository.findExamsByUsuarioId(id);
        }else {
            return (List<Exams>) new ResourceNotFoundException("Usuario con el identificador "+ id +"no tiene historial");
        }
    }

    @PostMapping("/public/analisis")
    public ExamsDTO analisis(@Valid @RequestBody ExamsDTO exams){
        if (exams.getAzucar()>70 && exams.getGrasa()>88.5 && exams.getOxigeno()<60){
            exams.setRiesgo("ALTO");
        } else if ((exams.getAzucar()>=50 && exams.getAzucar()<=70) && (exams.getGrasa()>=62.2 && exams.getGrasa()<=88.5) && (exams.getOxigeno()>=60 && exams.getOxigeno()<=70)) {
            exams.setRiesgo("MEDIO");
        } else if (exams.getAzucar()<50 && exams.getGrasa()<62.2 && exams.getOxigeno()>70){
            exams.setRiesgo("BAJO");
        } else {
            exams.setRiesgo("NO CONTEMPLADO EN LOS ESTUDIOS");
        }
        return exams;
    }

    @PostMapping("/private/analisis/guardar")
    public ResponseEntity<?> crear(@Valid @RequestBody Exams exams){
        if (exams.getAzucar()>70 && exams.getGrasa()>88.5 && exams.getOxigeno()<60){
            exams.setRiesgo("ALTO");
        } else if ((exams.getAzucar()>=50 && exams.getAzucar()<=70) && (exams.getGrasa()>=62.2 && exams.getGrasa()<=88.5) && (exams.getOxigeno()>=60 && exams.getOxigeno()<=70)) {
            exams.setRiesgo("MEDIO");
        } else if (exams.getAzucar()<50 && exams.getGrasa()<62.2 && exams.getOxigeno()>70){
            exams.setRiesgo("BAJO");
        } else {
            exams.setRiesgo("NO CONTEMPLADO EN LOS ESTUDIOS");
        }
        Exams exams1 = examService.guardar(exams);
        return ResponseEntity.status(HttpStatus.CREATED).body(exams1);
    }

    @GetMapping("private/analisis/all")
    public List<Exams> obtenerAll(){
        return examsRepository.findAll();
    }






    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
