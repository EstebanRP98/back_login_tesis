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
@Table(name = "carton")
public class Carton implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_carton")
    private Integer idcarton;
    @Column(name = "centimetros")
    private Integer centimetros;
    @Basic(optional = false)
    @Column(name = "precio")
    private double precio;

    public Carton() {
    }

    public Carton(Integer idcarton) {
        this.idcarton = idcarton;
    }

    public Carton(Integer idcarton, double precio) {
        this.idcarton = idcarton;
        this.precio = precio;
    }

    public Integer getIdcarton() {
        return idcarton;
    }

    public void setIdcarton(Integer idcarton) {
        this.idcarton = idcarton;
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
        hash += (idcarton != null ? idcarton.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carton)) {
            return false;
        }
        Carton other = (Carton) object;
        if ((this.idcarton == null && other.idcarton != null) || (this.idcarton != null && !this.idcarton.equals(other.idcarton))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.Carton[ idcarton=" + idcarton + " ]";
    }
    
}
