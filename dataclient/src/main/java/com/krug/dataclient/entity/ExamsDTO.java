package com.krug.dataclient.entity;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class ExamsDTO {
    @Digits(message = "Se admiten unicamente 2 decimales", integer = 3, fraction = 2)
    @Range(min = 0, max = 100, message = "Debe entar en un rango admitido de 0 a 100")
    private Double azucar;
    @Digits(message = "Se admiten unicamente 2 decimales", integer = 3, fraction = 2)
    @Range(min = 0, max = 100, message = "Debe entar en un rango admitido de 0 a 100")
    private Double grasa;

    @Digits(message = "Se admiten unicamente 2 decimales", integer = 3, fraction = 2)
    @Range(min = 0, max = 100, message = "Debe entar en un rango admitido de 0 a 100")
    private Double oxigeno;

    private String riesgo;

    public ExamsDTO(Double azucar, Double grasa, Double oxigeno, String riesgo) {
        this.azucar = azucar;
        this.grasa = grasa;
        this.oxigeno = oxigeno;
        this.riesgo = riesgo;
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
}
