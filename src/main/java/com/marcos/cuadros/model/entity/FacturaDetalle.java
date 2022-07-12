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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author david
 */
@Entity
@Table(name = "factura_detalle")
@NamedQueries({
        @NamedQuery(name = "FacturaDetalle.findAll", query = "SELECT f FROM FacturaDetalle f"),
        @NamedQuery(name = "FacturaDetalle.findByIdFacturaDetalle", query = "SELECT f FROM FacturaDetalle f WHERE f.idFacturaDetalle = :idFacturaDetalle"),
        @NamedQuery(name = "FacturaDetalle.findByDescripcion", query = "SELECT f FROM FacturaDetalle f WHERE f.descripcion = :descripcion"),
        @NamedQuery(name = "FacturaDetalle.findByDimensiones", query = "SELECT f FROM FacturaDetalle f WHERE f.dimensiones = :dimensiones"),
        @NamedQuery(name = "FacturaDetalle.findByCantidad", query = "SELECT f FROM FacturaDetalle f WHERE f.cantidad = :cantidad"),
        @NamedQuery(name = "FacturaDetalle.findBySubTotal", query = "SELECT f FROM FacturaDetalle f WHERE f.subTotal = :subTotal"),
        @NamedQuery(name = "FacturaDetalle.findByTotal", query = "SELECT f FROM FacturaDetalle f WHERE f.total = :total")})
public class FacturaDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_factura_detalle")
    private Integer idFacturaDetalle;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "dimensiones")
    private String dimensiones;
    @Column(name = "cantidad")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sub_total")
    private Double subTotal;
    @Column(name = "total")
    private Double total;
    @JoinColumn(name = "id_factura_cabecera", referencedColumnName = "factura_cabecera_id")
    @ManyToOne
    private FacturaCabecera idFacturaCabecera;
    @JoinColumn(name = "id_moldura_dos", referencedColumnName = "Id_moldura")
    @ManyToOne
    private Molduras idMolduraDos;
    @JoinColumn(name = "id_moldura_uno", referencedColumnName = "Id_moldura")
    @ManyToOne
    private Molduras idMolduraUno;
    @JoinColumn(name = "id_moldura_tres", referencedColumnName = "Id_moldura")
    @ManyToOne
    private Molduras idMolduraTres;

    public FacturaDetalle() {
    }

    public FacturaDetalle(Integer idFacturaDetalle) {
        this.idFacturaDetalle = idFacturaDetalle;
    }

    public Integer getIdFacturaDetalle() {
        return idFacturaDetalle;
    }

    public void setIdFacturaDetalle(Integer idFacturaDetalle) {
        this.idFacturaDetalle = idFacturaDetalle;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public FacturaCabecera getIdFacturaCabecera() {
        return idFacturaCabecera;
    }

    public void setIdFacturaCabecera(FacturaCabecera idFacturaCabecera) {
        this.idFacturaCabecera = idFacturaCabecera;
    }

    public Molduras getIdMolduraDos() {
        return idMolduraDos;
    }

    public void setIdMolduraDos(Molduras idMolduraDos) {
        this.idMolduraDos = idMolduraDos;
    }

    public Molduras getIdMolduraUno() {
        return idMolduraUno;
    }

    public void setIdMolduraUno(Molduras idMolduraUno) {
        this.idMolduraUno = idMolduraUno;
    }

    public Molduras getIdMolduraTres() {
        return idMolduraTres;
    }

    public void setIdMolduraTres(Molduras idMolduraTres) {
        this.idMolduraTres = idMolduraTres;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFacturaDetalle != null ? idFacturaDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaDetalle)) {
            return false;
        }
        FacturaDetalle other = (FacturaDetalle) object;
        if ((this.idFacturaDetalle == null && other.idFacturaDetalle != null) || (this.idFacturaDetalle != null && !this.idFacturaDetalle.equals(other.idFacturaDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.FacturaDetalle[ idFacturaDetalle=" + idFacturaDetalle + " ]";
    }

}
