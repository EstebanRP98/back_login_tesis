/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcos.cuadros.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author david
 */
@Entity
@Table(name = "vidrio_sr")
public class VidrioSr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_vidrio_sr")
    private Integer idvidriosr;
    @Column(name = "centimetros")
    private Integer centimetros;
    @Basic(optional = false)
    @Column(name = "precio")
    private double precio;

    public VidrioSr() {
    }

    public VidrioSr(Integer idvidriosr) {
        this.idvidriosr = idvidriosr;
    }

    public VidrioSr(Integer idvidriosr, double precio) {
        this.idvidriosr = idvidriosr;
        this.precio = precio;
    }

    public Integer getIdvidriosr() {
        return idvidriosr;
    }

    public void setIdvidriosr(Integer idvidriosr) {
        this.idvidriosr = idvidriosr;
    }

    public Integer getCentimetros() {
        return centimetros;
    }

    public void setCentimetros(Integer centimetros) {
        this.centimetros = centimetros;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvidriosr != null ? idvidriosr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VidrioSr)) {
            return false;
        }
        VidrioSr other = (VidrioSr) object;
        if ((this.idvidriosr == null && other.idvidriosr != null) || (this.idvidriosr != null && !this.idvidriosr.equals(other.idvidriosr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.VidrioSr[ idvidriosr=" + idvidriosr + " ]";
    }
    
}
