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
@Table(name = "vidrio_n")
public class VidrioN implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_vidrio_n")
    private Integer idvidrion;
    @Column(name = "centimetros")
    private Integer centimetros;
    @Basic(optional = false)
    @Column(name = "precio")
    private double precio;

    public VidrioN() {
    }

    public VidrioN(Integer idvidrion) {
        this.idvidrion = idvidrion;
    }

    public VidrioN(Integer idvidrion, double precio) {
        this.idvidrion = idvidrion;
        this.precio = precio;
    }

    public Integer getIdvidrion() {
        return idvidrion;
    }

    public void setIdvidrion(Integer idvidrion) {
        this.idvidrion = idvidrion;
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
        hash += (idvidrion != null ? idvidrion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VidrioN)) {
            return false;
        }
        VidrioN other = (VidrioN) object;
        if ((this.idvidrion == null && other.idvidrion != null) || (this.idvidrion != null && !this.idvidrion.equals(other.idvidrion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.VidrioN[ idvidrion=" + idvidrion + " ]";
    }
    
}
