/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcos.cuadros.model.entity;

import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "factura_cabecera")
public class FacturaCabecera implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @Basic(optional = false)
        @Column(name = "factura_cabecera_id")
        private Integer facturaCabeceraId;
        @Column(name = "fecha")
        @Temporal(TemporalType.DATE)
        private Date fecha;
        @Column(name = "numero_factura")
        private Integer numeroFactura;
        @Column(name = "usuario_nombre")
        private String usuarioNombre;
        @OneToMany(mappedBy = "idFacturaCabecera")
        private Collection<FacturaDetalle> facturaDetalleCollection;
        @JoinColumn(name = "cliente_id", referencedColumnName = "Id_cliente")
        @ManyToOne
        private Clientes clienteId;
        @JoinColumn(name = "usuario_id", referencedColumnName = "id")
        @ManyToOne
        private UserEntity usuarioId;

        public FacturaCabecera() {
        }

        public FacturaCabecera(Integer facturaCabeceraId) {
            this.facturaCabeceraId = facturaCabeceraId;
        }

        public Integer getFacturaCabeceraId() {
            return facturaCabeceraId;
        }

        public void setFacturaCabeceraId(Integer facturaCabeceraId) {
            this.facturaCabeceraId = facturaCabeceraId;
        }

        public Date getFecha() {
            return fecha;
        }

        public void setFecha(Date fecha) {
            this.fecha = fecha;
        }

        public Integer getNumeroFactura() {
            return numeroFactura;
        }

        public void setNumeroFactura(Integer numeroFactura) {
            this.numeroFactura = numeroFactura;
        }

        public String getUsuarioNombre() {
            return usuarioNombre;
        }

        public void setUsuarioNombre(String usuarioNombre) {
            this.usuarioNombre = usuarioNombre;
        }

        public Collection<FacturaDetalle> getFacturaDetalleCollection() {
            return facturaDetalleCollection;
        }

        public void setFacturaDetalleCollection(Collection<FacturaDetalle> facturaDetalleCollection) {
            this.facturaDetalleCollection = facturaDetalleCollection;
        }

        public Clientes getClienteId() {
            return clienteId;
        }

        public void setClienteId(Clientes clienteId) {
            this.clienteId = clienteId;
        }

        public UserEntity getUsuarioId() {
            return usuarioId;
        }

        public void setUsuarioId(UserEntity usuarioId) {
            this.usuarioId = usuarioId;
        }

        @Override
        public int hashCode() {
            int hash = 0;
            hash += (facturaCabeceraId != null ? facturaCabeceraId.hashCode() : 0);
            return hash;
        }

        @Override
        public boolean equals(Object object) {
            // TODO: Warning - this method won't work in the case the id fields are not set
            if (!(object instanceof FacturaCabecera)) {
                return false;
            }
            FacturaCabecera other = (FacturaCabecera) object;
            if ((this.facturaCabeceraId == null && other.facturaCabeceraId != null) || (this.facturaCabeceraId != null && !this.facturaCabeceraId.equals(other.facturaCabeceraId))) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "com.mycompany.mavenproject1.FacturaCabecera[ facturaCabeceraId=" + facturaCabeceraId + " ]";
        }
    
}
