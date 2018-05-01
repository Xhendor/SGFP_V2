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
@Table(name = "reservacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservacion.findAll", query = "SELECT r FROM Reservacion r")
    , @NamedQuery(name = "Reservacion.findByIdReservacion", query = "SELECT r FROM Reservacion r WHERE r.idReservacion = :idReservacion")
    , @NamedQuery(name = "Reservacion.findByFecha", query = "SELECT r FROM Reservacion r WHERE r.fecha = :fecha")
    , @NamedQuery(name = "Reservacion.findByConcepto", query = "SELECT r FROM Reservacion r WHERE r.concepto = :concepto")})
public class Reservacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_reservacion")
    private Integer idReservacion;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "concepto")
    private String concepto;
    @JoinColumn(name = "fk_instalaciones", referencedColumnName = "id_instalaciones")
    @ManyToOne(optional = false)
    private Instalaciones fkInstalaciones;

    public Reservacion() {
    }

    public Reservacion(Integer idReservacion) {
        this.idReservacion = idReservacion;
    }

    public Reservacion(Integer idReservacion, Date fecha) {
        this.idReservacion = idReservacion;
        this.fecha = fecha;
    }

    public Integer getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(Integer idReservacion) {
        this.idReservacion = idReservacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Instalaciones getFkInstalaciones() {
        return fkInstalaciones;
    }

    public void setFkInstalaciones(Instalaciones fkInstalaciones) {
        this.fkInstalaciones = fkInstalaciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReservacion != null ? idReservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservacion)) {
            return false;
        }
        Reservacion other = (Reservacion) object;
        if ((this.idReservacion == null && other.idReservacion != null) || (this.idReservacion != null && !this.idReservacion.equals(other.idReservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sgfp.entidades.Reservacion[ idReservacion=" + idReservacion + " ]";
    }
    
}
