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
@Table(name = "rel_convenio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelConvenio.findAll", query = "SELECT r FROM RelConvenio r")
    , @NamedQuery(name = "RelConvenio.findByIdRelConvenio", query = "SELECT r FROM RelConvenio r WHERE r.idRelConvenio = :idRelConvenio")
    , @NamedQuery(name = "RelConvenio.findByConcepto", query = "SELECT r FROM RelConvenio r WHERE r.concepto = :concepto")
    , @NamedQuery(name = "RelConvenio.findByFechaIni", query = "SELECT r FROM RelConvenio r WHERE r.fechaIni = :fechaIni")
    , @NamedQuery(name = "RelConvenio.findByFechaFin", query = "SELECT r FROM RelConvenio r WHERE r.fechaFin = :fechaFin")
    , @NamedQuery(name = "RelConvenio.findByPagado", query = "SELECT r FROM RelConvenio r WHERE r.pagado = :pagado")})
public class RelConvenio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_rel_convenio")
    private Integer idRelConvenio;
    @Basic(optional = false)
    @Column(name = "concepto")
    private String concepto;
    @Basic(optional = false)
    @Column(name = "fecha_ini")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIni;
    @Basic(optional = false)
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Basic(optional = false)
    @Column(name = "pagado")
    private boolean pagado;
    @JoinColumn(name = "fk_vivienda", referencedColumnName = "id_vivienda")
    @ManyToOne(optional = false)
    private Vivienda fkVivienda;

    public RelConvenio() {
    }

    public RelConvenio(Integer idRelConvenio) {
        this.idRelConvenio = idRelConvenio;
    }

    public RelConvenio(Integer idRelConvenio, String concepto, Date fechaIni, Date fechaFin, boolean pagado) {
        this.idRelConvenio = idRelConvenio;
        this.concepto = concepto;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.pagado = pagado;
    }

    public Integer getIdRelConvenio() {
        return idRelConvenio;
    }

    public void setIdRelConvenio(Integer idRelConvenio) {
        this.idRelConvenio = idRelConvenio;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
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

    public boolean getPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
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
        hash += (idRelConvenio != null ? idRelConvenio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelConvenio)) {
            return false;
        }
        RelConvenio other = (RelConvenio) object;
        if ((this.idRelConvenio == null && other.idRelConvenio != null) || (this.idRelConvenio != null && !this.idRelConvenio.equals(other.idRelConvenio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sgfp.entidades.RelConvenio[ idRelConvenio=" + idRelConvenio + " ]";
    }
    
}
