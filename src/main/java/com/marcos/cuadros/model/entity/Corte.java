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
@Table(name = "corte")
public class Corte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_corte")
    private Integer idcorte;
    @Column(name = "centimetros")
    private Integer centimetros;
    @Basic(optional = false)
    @Column(name = "precio")
    private double precio;

    public Corte() {
    }

    public Corte(Integer idcorte) {
        this.idcorte = idcorte;
    }

    public Corte(Integer idcorte, double precio) {
        this.idcorte = idcorte;
        this.precio = precio;
    }

    public Integer getIdcorte() {
        return idcorte;
    }

    public void setIdcorte(Integer idcorte) {
        this.idcorte = idcorte;
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
        hash += (idcorte != null ? idcorte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Corte)) {
            return false;
        }
        Corte other = (Corte) object;
        if ((this.idcorte == null && other.idcorte != null) || (this.idcorte != null && !this.idcorte.equals(other.idcorte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.Corte[ idcorte=" + idcorte + " ]";
    }
    
}
