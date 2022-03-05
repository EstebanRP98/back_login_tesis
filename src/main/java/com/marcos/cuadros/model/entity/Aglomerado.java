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
@Table(name = "aglomerado")
public class Aglomerado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_aglomerado")
    private Integer idaglomerado;
    @Column(name = "centimetros")
    private Integer centimetros;
    @Basic(optional = false)
    @Column(name = "precio")
    private double precio;

    public Aglomerado() {
    }

    public Aglomerado(Integer idaglomerado) {
        this.idaglomerado = idaglomerado;
    }

    public Aglomerado(Integer idaglomerado, double precio) {
        this.idaglomerado = idaglomerado;
        this.precio = precio;
    }

    public Integer getIdaglomerado() {
        return idaglomerado;
    }

    public void setIdaglomerado(Integer idaglomerado) {
        this.idaglomerado = idaglomerado;
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
        hash += (idaglomerado != null ? idaglomerado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aglomerado)) {
            return false;
        }
        Aglomerado other = (Aglomerado) object;
        if ((this.idaglomerado == null && other.idaglomerado != null) || (this.idaglomerado != null && !this.idaglomerado.equals(other.idaglomerado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.Aglomerado[ idaglomerado=" + idaglomerado + " ]";
    }
    
}
