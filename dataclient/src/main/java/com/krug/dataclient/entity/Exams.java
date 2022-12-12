package com.krug.dataclient.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exams")
public class Exams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Range(min = 0, max = 100)
    @NotNull(message = "No puede estar vacio")
    private Double azucar;

    @Range(min = 0, max = 100)
    @NotNull (message = "No puede estar vacio")
    private Double grasa;

    @Range(min = 0, max = 100)
    @NotNull(message = "No puede estar vacio")
    private Double oxigeno;

    //@NotEmpty(message = "No puede estar vacio")
    private String riesgo;

    @NotNull(message = "No puede estar vacio")
    private Integer usuarioId;

   // @ManyToOne(cascade = CascadeType.ALL)
   // private ExamsUser examsUsers;

    public Exams(Integer id, Double azucar, Double grasa, Double oxigeno, String riesgo, Integer usuarioId) {
        this.id = id;
        this.azucar = azucar;
        this.grasa = grasa;
        this.oxigeno = oxigeno;
        this.riesgo = riesgo;
        this.usuarioId = usuarioId;
    }
    public Exams(Double azucar, Double grasa, Double oxigeno) {
        this.azucar = azucar;
        this.grasa = grasa;
        this.oxigeno = oxigeno;
    }

    public Exams() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAzucar() {
        return azucar;
    }

    public void setAzucar(Double azucar) {
        this.azucar = azucar;
    }

    public Double getGrasa() {
        return grasa;
    }

    public void setGrasa(Double grasa) {
        this.grasa = grasa;
    }

    public Double getOxigeno() {
        return oxigeno;
    }

    public void setOxigeno(Double oxigeno) {
        this.oxigeno = oxigeno;
    }

    public String getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(String riesgo) {
        this.riesgo = riesgo;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
}
