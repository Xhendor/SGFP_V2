/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sgfp.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author xhendor
 */
@Entity
@Table(name = "rel_mantenimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelMantenimiento.findAll", query = "SELECT r FROM RelMantenimiento r")
    , @NamedQuery(name = "RelMantenimiento.findByIdRelMantenimiento", query = "SELECT r FROM RelMantenimiento r WHERE r.idRelMantenimiento = :idRelMantenimiento")
    , @NamedQuery(name = "RelMantenimiento.findByCantidad", query = "SELECT r FROM RelMantenimiento r WHERE r.cantidad = :cantidad")
    , @NamedQuery(name = "RelMantenimiento.findByFechaIni", query = "SELECT r FROM RelMantenimiento r WHERE r.fechaIni = :fechaIni")
    , @NamedQuery(name = "RelMantenimiento.findByFechaFin", query = "SELECT r FROM RelMantenimiento r WHERE r.fechaFin = :fechaFin")
    , @NamedQuery(name = "RelMantenimiento.findByPeriodo", query = "SELECT r FROM RelMantenimiento r WHERE r.periodo = :periodo")
    , @NamedQuery(name = "RelMantenimiento.findByFechaPago", query = "SELECT r FROM RelMantenimiento r WHERE r.fechaPago = :fechaPago")})
public class RelMantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_rel_mantenimiento")
    private Integer idRelMantenimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad")
    private Float cantidad;
    @Column(name = "fecha_ini")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIni;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Basic(optional = false)
    @Column(name = "periodo")
    private int periodo;
    @Column(name = "fecha_pago")
    private String fechaPago;
    @JoinColumn(name = "fk_vivienda", referencedColumnName = "id_vivienda")
    @ManyToOne(optional = false)
    private Vivienda fkVivienda;

    public RelMantenimiento() {
    }

    public RelMantenimiento(Integer idRelMantenimiento) {
        this.idRelMantenimiento = idRelMantenimiento;
    }

    public RelMantenimiento(Integer idRelMantenimiento, int periodo) {
        this.idRelMantenimiento = idRelMantenimiento;
        this.periodo = periodo;
    }

    public Integer getIdRelMantenimiento() {
        return idRelMantenimiento;
    }

    public void setIdRelMantenimiento(Integer idRelMantenimiento) {
        this.idRelMantenimiento = idRelMantenimiento;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Vivienda getFkVivienda() {
        return fkVivienda;
    }

    public void setFkVivienda(Vivienda fkVivienda) {
        this.fkVivienda = fkVivienda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRelMantenimiento != null ? idRelMantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelMantenimiento)) {
            return false;
        }
        RelMantenimiento other = (RelMantenimiento) object;
        if ((this.idRelMantenimiento == null && other.idRelMantenimiento != null) || (this.idRelMantenimiento != null && !this.idRelMantenimiento.equals(other.idRelMantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sgfp.entidades.RelMantenimiento[ idRelMantenimiento=" + idRelMantenimiento + " ]";
    }
    
}
