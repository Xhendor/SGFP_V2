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
@Table(name = "tipo_instalacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoInstalacion.findAll", query = "SELECT t FROM TipoInstalacion t")
    , @NamedQuery(name = "TipoInstalacion.findByIdTipoInstalacion", query = "SELECT t FROM TipoInstalacion t WHERE t.idTipoInstalacion = :idTipoInstalacion")
    , @NamedQuery(name = "TipoInstalacion.findByTipo", query = "SELECT t FROM TipoInstalacion t WHERE t.tipo = :tipo")})
public class TipoInstalacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_instalacion")
    private Integer idTipoInstalacion;
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkTipoInstalacion")
    private List<Instalaciones> instalacionesList;

    public TipoInstalacion() {
    }

    public TipoInstalacion(Integer idTipoInstalacion) {
        this.idTipoInstalacion = idTipoInstalacion;
    }

    public Integer getIdTipoInstalacion() {
        return idTipoInstalacion;
    }

    public void setIdTipoInstalacion(Integer idTipoInstalacion) {
        this.idTipoInstalacion = idTipoInstalacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Instalaciones> getInstalacionesList() {
        return instalacionesList;
    }

    public void setInstalacionesList(List<Instalaciones> instalacionesList) {
        this.instalacionesList = instalacionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoInstalacion != null ? idTipoInstalacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoInstalacion)) {
            return false;
        }
        TipoInstalacion other = (TipoInstalacion) object;
        if ((this.idTipoInstalacion == null && other.idTipoInstalacion != null) || (this.idTipoInstalacion != null && !this.idTipoInstalacion.equals(other.idTipoInstalacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.app.sgfp.entidades.TipoInstalacion[ idTipoInstalacion=" + idTipoInstalacion + " ]";
    }
    
}
