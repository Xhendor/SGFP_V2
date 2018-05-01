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
@Table(name = "vivienda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vivienda.findAll", query = "SELECT v FROM Vivienda v")
    , @NamedQuery(name = "Vivienda.findByIdVivienda", query = "SELECT v FROM Vivienda v WHERE v.idVivienda = :idVivienda")
    , @NamedQuery(name = "Vivienda.findByCalle", query = "SELECT v FROM Vivienda v WHERE v.calle = :calle")
    , @NamedQuery(name = "Vivienda.findByNumeroExterior", query = "SELECT v FROM Vivienda v WHERE v.numeroExterior = :numeroExterior")
    , @NamedQuery(name = "Vivienda.findByHabitada", query = "SELECT v FROM Vivienda v WHERE v.habitada = :habitada")
    , @NamedQuery(name = "Vivienda.findByRenta", query = "SELECT v FROM Vivienda v WHERE v.renta = :renta")})
public class Vivienda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vivienda")
    private Integer idVivienda;
    @Basic(optional = false)
    @Column(name = "calle")
    private String calle;
    @Basic(optional = false)
    @Column(name = "numero_exterior")
    private String numeroExterior;
    @Basic(optional = false)
    @Column(name = "habitada")
    private boolean habitada;
    @Basic(optional = false)
    @Column(name = "renta")
    private boolean renta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkVivienda")
    private List<Contacto> contactoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkVivienda")
    private List<RelConvenio> relConvenioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkVivienda")
    private List<RelMantenimiento> relMantenimientoList;

    public Vivienda() {
    }

    public Vivienda(Integer idVivienda) {
        this.idVivienda = idVivienda;
    }

    public Vivienda(Integer idVivienda, String calle, String numeroExterior, boolean habitada, boolean renta) {
        this.idVivienda = idVivienda;
        this.calle = calle;
        this.numeroExterior = numeroExterior;
        this.habitada = habitada;
        this.renta = renta;
    }

    public Integer getIdVivienda() {
        return idVivienda;
    }

    public void setIdVivienda(Integer idVivienda) {
        this.idVivienda = idVivienda;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public boolean getHabitada() {
        return habitada;
    }

    public void setHabitada(boolean habitada) {
        this.habitada = habitada;
    }

    public boolean getRenta() {
        return renta;
    }

    public void setRenta(boolean renta) {
        this.renta = renta;
    }

    @XmlTransient
    public List<Contacto> getContactoList() {
        return contactoList;
    }

    public void setContactoList(List<Contacto> contactoList) {
        this.contactoList = contactoList;
    }

    @XmlTransient
    public List<RelConvenio> getRelConvenioList() {
        return relConvenioList;
    }

    public void setRelConvenioList(List<RelConvenio> relConvenioList) {
        this.relConvenioList = relConvenioList;
    }

    @XmlTransient
    public List<RelMantenimiento> getRelMantenimientoList() {
        return relMantenimientoList;
    }

    public void setRelMantenimientoList(List<RelMantenimiento> relMantenimientoList) {
        this.relMantenimientoList = relMantenimientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVivienda != null ? idVivienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vivienda)) {
            return false;
        }
        Vivienda other = (Vivienda) object;
        if ((this.idVivienda == null && other.idVivienda != null) || (this.idVivienda != null && !this.idVivienda.equals(other.idVivienda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sgfp.entidades.Vivienda[ idVivienda=" + idVivienda + " ]";
    }
    
}
