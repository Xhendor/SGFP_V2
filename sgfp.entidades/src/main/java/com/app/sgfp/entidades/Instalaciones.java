/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.sgfp.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author xhendor
 */
@Entity
@Table(name = "instalaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instalaciones.findAll", query = "SELECT i FROM Instalaciones i")
    , @NamedQuery(name = "Instalaciones.findByIdInstalaciones", query = "SELECT i FROM Instalaciones i WHERE i.idInstalaciones = :idInstalaciones")
    , @NamedQuery(name = "Instalaciones.findByNombre", query = "SELECT i FROM Instalaciones i WHERE i.nombre = :nombre")
    , @NamedQuery(name = "Instalaciones.findByRenta", query = "SELECT i FROM Instalaciones i WHERE i.renta = :renta")})
public class Instalaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_instalaciones")
    private Integer idInstalaciones;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "renta")
    private Boolean renta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkInstalaciones")
    private List<Reservacion> reservacionList;
    @JoinColumn(name = "fk_tipo_instalacion", referencedColumnName = "id_tipo_instalacion")
    @ManyToOne(optional = false)
    private TipoInstalacion fkTipoInstalacion;

    public Instalaciones() {
    }

    public Instalaciones(Integer idInstalaciones) {
        this.idInstalaciones = idInstalaciones;
    }

    public Integer getIdInstalaciones() {
        return idInstalaciones;
    }

    public void setIdInstalaciones(Integer idInstalaciones) {
        this.idInstalaciones = idInstalaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getRenta() {
        return renta;
    }

    public void setRenta(Boolean renta) {
        this.renta = renta;
    }

    @XmlTransient
    public List<Reservacion> getReservacionList() {
        return reservacionList;
    }

    public void setReservacionList(List<Reservacion> reservacionList) {
        this.reservacionList = reservacionList;
    }

    public TipoInstalacion getFkTipoInstalacion() {
        return fkTipoInstalacion;
    }

    public void setFkTipoInstalacion(TipoInstalacion fkTipoInstalacion) {
        this.fkTipoInstalacion = fkTipoInstalacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstalaciones != null ? idInstalaciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instalaciones)) {
            return false;
        }
        Instalaciones other = (Instalaciones) object;
        if ((this.idInstalaciones == null && other.idInstalaciones != null) || (this.idInstalaciones != null && !this.idInstalaciones.equals(other.idInstalaciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sgfp.entidades.Instalaciones[ idInstalaciones=" + idInstalaciones + " ]";
    }
    
}
