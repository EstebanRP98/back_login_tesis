/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcos.cuadros.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author david
 */
@Entity
@Table(name = "molduras")
public class Molduras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_moldura")
    @SequenceGenerator(name = "SID_MOLDURAS", sequenceName = "SID_MOLDURAS", initialValue = 356, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SID_MOLDURAS")
    private Integer idmoldura;
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "precio")
    private double precio;

    public Molduras() {
    }

    public Molduras(Integer idmoldura) {
        this.idmoldura = idmoldura;
    }

    public Molduras(Integer idmoldura, double precio) {
        this.idmoldura = idmoldura;
        this.precio = precio;
    }

    public Integer getIdmoldura() {
        return idmoldura;
    }

    public void setIdmoldura(Integer idmoldura) {
        this.idmoldura = idmoldura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (idmoldura != null ? idmoldura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Molduras)) {
            return false;
        }
        Molduras other = (Molduras) object;
        if ((this.idmoldura == null && other.idmoldura != null) || (this.idmoldura != null && !this.idmoldura.equals(other.idmoldura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.Molduras[ idmoldura=" + idmoldura + " ]";
    }
    
}
