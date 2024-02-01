/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author David
 */
@Entity
@NamedQueries({
    @NamedQuery(
            name = "encontrarTiendaEvento", query = "SELECT te FROM TiendaEvento te WHERE te.idTiendaEvento.idTienda = :idTienda AND te.idTiendaEvento.idEvento = :idEvento"
    )
    ,

    @NamedQuery(
            name = "encontrarTodosTiendaEvento", query = "SELECT te FROM TiendaEvento te"
    ),})
@Table(name = "tienda_evento", schema = "marketMaker")
@XmlRootElement
public class TiendaEvento implements Serializable {

    @EmbeddedId
    private TiendaEventoId idTiendaEvento;
    // @JsonIgnore
    @MapsId("idTienda")
    @ManyToOne
    private Tienda tienda;

    // @JsonIgnore
    @MapsId("idEvento")
    @ManyToOne
    private Evento evento;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInscripcion;

    public TiendaEventoId getIdTiendaEvento() {
        return idTiendaEvento;
    }

    public void setIdTiendaEvento(TiendaEventoId idTiendaEvento) {
        this.idTiendaEvento = idTiendaEvento;
    }

    public Tienda getTienda() {
        return tienda;
    }

    @XmlTransient
    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    @XmlTransient
    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idTiendaEvento);
        hash = 97 * hash + Objects.hashCode(this.tienda);
        hash = 97 * hash + Objects.hashCode(this.evento);
        hash = 97 * hash + Objects.hashCode(this.fechaInscripcion);
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
        final TiendaEvento other = (TiendaEvento) obj;
        if (!Objects.equals(this.idTiendaEvento, other.idTiendaEvento)) {
            return false;
        }
        if (!Objects.equals(this.tienda, other.tienda)) {
            return false;
        }
        if (!Objects.equals(this.evento, other.evento)) {
            return false;
        }
        if (!Objects.equals(this.fechaInscripcion, other.fechaInscripcion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TiendaEvento{" + "idTiendaEvento=" + idTiendaEvento + ", tienda=" + tienda + ", evento=" + evento + ", fechaInscripcion=" + fechaInscripcion + '}';
    }

}
