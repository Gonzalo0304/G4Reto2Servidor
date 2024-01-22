/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author inigo
 */
@Entity
@Table(name = "Evento", schema = "marketMaker")
@NamedQueries({
    @NamedQuery(
            name = "encontrarTodosEventos", query = "SELECT e FROM Evento e"
    )
    ,

    @NamedQuery(
            name = "encontrarEventoMayorNumParticipantes", query = "SELECT e FROM Evento e WHERE numParticipantes>:numParticipantes"
    )
    ,

    @NamedQuery(
            name = "encontrarEventoMenorNumParticipantes", query = "SELECT e FROM Evento e WHERE numParticipantes<:numParticipantes"
    )
    ,

    @NamedQuery(
            name = "encontrarEventoEntreParticipantes", query = "SELECT e FROM Evento e WHERE numParticipantes>=:numParticipantesMin and numParticipantes<=:numParticipantesMax"
    )
    ,

    @NamedQuery(
            name = "encontrarEventoMayorRecaudado", query = "SELECT e FROM Evento e WHERE totalRecaudado>:totalRecaudado"
    )
    ,

    @NamedQuery(
            name = "encontrarEventoMenorRecaudado", query = "SELECT e FROM Evento e WHERE totalRecaudado<:totalRecaudado"
    )
    ,

    @NamedQuery(
            name = "encontrarEventoEntreRecaudado", query = "SELECT e FROM Evento e WHERE totalRecaudado>=:totalRecaudadoMin and totalRecaudado<=:totalRecaudadoMax"
    ),})
@XmlRootElement
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEvento;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    private double totalRecaudado;
    private int numParticipantes;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Admin_Evento", schema = "marketMaker")
    private List<Administrador> administradores;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evento")
    private List<TiendaEvento> listaTiendasEvento;

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotalRecaudado() {
        return totalRecaudado;
    }

    public void setTotalRecaudado(double totalRecaudado) {
        this.totalRecaudado = totalRecaudado;
    }

    public int getNumParticipantes() {
        return numParticipantes;
    }

    public void setNumParticipantes(int numParticipantes) {
        this.numParticipantes = numParticipantes;
    }

    @XmlTransient
    public List<Administrador> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(List<Administrador> administradores) {
        this.administradores = administradores;
    }

    @XmlTransient
    public List<TiendaEvento> getListaTiendasEvento() {
        return listaTiendasEvento;
    }

    public void setListaTiendasEvento(List<TiendaEvento> listaTiendasEvento) {
        this.listaTiendasEvento = listaTiendasEvento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.idEvento;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evento other = (Evento) obj;
        if (this.idEvento != other.idEvento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Evento{" + "idEvento=" + idEvento + ", fecha=" + fecha + ", totalRecaudado=" + totalRecaudado + ", numParticipantes=" + numParticipantes + ", administradores=" + administradores + ", listaTiendasEvento=" + listaTiendasEvento + '}';
    }

}
