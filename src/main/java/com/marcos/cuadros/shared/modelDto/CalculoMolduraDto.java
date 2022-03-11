package com.marcos.cuadros.shared.modelDto;

import lombok.Data;

public class CalculoMolduraDto {

    private Double medida1;
    private Double medida2;
    private Integer idmoldura;
    private Boolean aglomerado;
    private Integer cantidadAglomerado;
    private Boolean paspartu;
    private Integer cantidadPaspartu;
    private Boolean carton;
    private Integer cantidadCarton;
    private Boolean vidrioSr;
    private Integer cantidadVidrioSr;
    private Boolean vidrioN;
    private Integer cantidadVidrioN;


    public Double getMedida1() {
        return medida1;
    }

    public void setMedida1(Double medida1) {
        this.medida1 = medida1;
    }

    public Double getMedida2() {
        return medida2;
    }

    public void setMedida2(Double medida2) {
        this.medida2 = medida2;
    }

    public Integer getIdmoldura() {
        return idmoldura;
    }

    public void setIdmoldura(Integer idmoldura) {
        this.idmoldura = idmoldura;
    }

    public Boolean getAglomerado() {
        return aglomerado;
    }

    public void setAglomerado(Boolean aglomerado) {
        this.aglomerado = aglomerado;
    }

    public Integer getCantidadAglomerado() {
        return cantidadAglomerado;
    }

    public void setCantidadAglomerado(Integer cantidadAglomerado) {
        this.cantidadAglomerado = cantidadAglomerado;
    }

    public Boolean getPaspartu() {
        return paspartu;
    }

    public void setPaspartu(Boolean paspartu) {
        this.paspartu = paspartu;
    }

    public Integer getCantidadPaspartu() {
        return cantidadPaspartu;
    }

    public void setCantidadPaspartu(Integer cantidadPaspartu) {
        this.cantidadPaspartu = cantidadPaspartu;
    }

    public Boolean getCarton() {
        return carton;
    }

    public void setCarton(Boolean carton) {
        this.carton = carton;
    }

    public Integer getCantidadCarton() {
        return cantidadCarton;
    }

    public void setCantidadCarton(Integer cantidadCarton) {
        this.cantidadCarton = cantidadCarton;
    }

    public Boolean getVidrioSr() {
        return vidrioSr;
    }

    public void setVidrioSr(Boolean vidrioSr) {
        this.vidrioSr = vidrioSr;
    }

    public Integer getCantidadVidrioSr() {
        return cantidadVidrioSr;
    }

    public void setCantidadVidrioSr(Integer cantidadVidrioSr) {
        this.cantidadVidrioSr = cantidadVidrioSr;
    }

    public Boolean getVidrioN() {
        return vidrioN;
    }

    public void setVidrioN(Boolean vidrioN) {
        this.vidrioN = vidrioN;
    }

    public Integer getCantidadVidrioN() {
        return cantidadVidrioN;
    }

    public void setCantidadVidrioN(Integer cantidadVidrioN) {
        this.cantidadVidrioN = cantidadVidrioN;
    }
}
