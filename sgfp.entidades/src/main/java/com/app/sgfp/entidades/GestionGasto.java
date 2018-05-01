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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "gestion_gasto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GestionGasto.findAll", query = "SELECT g FROM GestionGasto g")
    , @NamedQuery(name = "GestionGasto.findByIdGestionGasto", query = "SELECT g FROM GestionGasto g WHERE g.idGestionGasto = :idGestionGasto")
    , @NamedQuery(name = "GestionGasto.findByFecha", query = "SELECT g FROM GestionGasto g WHERE g.fecha = :fecha")
    , @NamedQuery(name = "GestionGasto.findByCantidad", query = "SELECT g FROM GestionGasto g WHERE g.cantidad = :cantidad")
    , @NamedQuery(name = "GestionGasto.findByConcepto", query = "SELECT g FROM GestionGasto g WHERE g.concepto = :concepto")
    , @NamedQuery(name = "GestionGasto.findByGestionGastocol", query = "SELECT g FROM GestionGasto g WHERE g.gestionGastocol = :gestionGastocol")})
public class GestionGasto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_gestion_gasto")
    private Integer idGestionGasto;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private float cantidad;
    @Basic(optional = false)
    @Column(name = "concepto")
    private String concepto;
    @Column(name = "gestion_gastocol")
    private String gestionGastocol;

    public GestionGasto() {
    }

    public GestionGasto(Integer idGestionGasto) {
        this.idGestionGasto = idGestionGasto;
    }

    public GestionGasto(Integer idGestionGasto, Date fecha, float cantidad, String concepto) {
        this.idGestionGasto = idGestionGasto;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.concepto = concepto;
    }

    public Integer getIdGestionGasto() {
        return idGestionGasto;
    }

    public void setIdGestionGasto(Integer idGestionGasto) {
        this.idGestionGasto = idGestionGasto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getGestionGastocol() {
        return gestionGastocol;
    }

    public void setGestionGastocol(String gestionGastocol) {
        this.gestionGastocol = gestionGastocol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGestionGasto != null ? idGestionGasto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GestionGasto)) {
            return false;
        }
        GestionGasto other = (GestionGasto) object;
        if ((this.idGestionGasto == null && other.idGestionGasto != null) || (this.idGestionGasto != null && !this.idGestionGasto.equals(other.idGestionGasto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sgfp.entidades.GestionGasto[ idGestionGasto=" + idGestionGasto + " ]";
    }
    
}
