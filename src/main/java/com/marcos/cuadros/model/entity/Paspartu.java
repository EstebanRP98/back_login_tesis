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
@Table(name = "paspartu")
public class Paspartu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_paspartu")
    private Integer idpaspartu;
    @Column(name = "centimetros")
    private Integer centimetros;
    @Basic(optional = false)
    @Column(name = "precio")
    private double precio;

    public Paspartu() {
    }

    public Paspartu(Integer idpaspartu) {
        this.idpaspartu = idpaspartu;
    }

    public Paspartu(Integer idpaspartu, double precio) {
        this.idpaspartu = idpaspartu;
        this.precio = precio;
    }

    public Integer getIdpaspartu() {
        return idpaspartu;
    }

    public void setIdpaspartu(Integer idpaspartu) {
        this.idpaspartu = idpaspartu;
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
        hash += (idpaspartu != null ? idpaspartu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paspartu)) {
            return false;
        }
        Paspartu other = (Paspartu) object;
        if ((this.idpaspartu == null && other.idpaspartu != null) || (this.idpaspartu != null && !this.idpaspartu.equals(other.idpaspartu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.Paspartu[ idpaspartu=" + idpaspartu + " ]";
    }
    
}
