/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.peliculas.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author Otherside
 */
@Entity
@Table(name = "clientes_peliculas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientesPeliculas.findAll", query = "SELECT c FROM ClientesPeliculas c")
    , @NamedQuery(name = "ClientesPeliculas.findById", query = "SELECT c FROM ClientesPeliculas c WHERE c.id = :id")
    , @NamedQuery(name = "ClientesPeliculas.findByCreatedAt", query = "SELECT c FROM ClientesPeliculas c WHERE c.createdAt = :createdAt")
    , @NamedQuery(name = "ClientesPeliculas.findByUpdatedAt", query = "SELECT c FROM ClientesPeliculas c WHERE c.updatedAt = :updatedAt")})
public class ClientesPeliculas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "id_pelicula", referencedColumnName = "id")
    @ManyToOne
    private Peliculas idPelicula;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @ManyToOne
    private Users idCliente;

    public ClientesPeliculas() {
    }

    public ClientesPeliculas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Peliculas getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Peliculas idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Users getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Users idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientesPeliculas)) {
            return false;
        }
        ClientesPeliculas other = (ClientesPeliculas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.ClientesPeliculas[ id=" + id + " ]";
    }
    
}
