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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author David
 */
@Entity
@Table(name="Tienda_Evento", schema="marketMaker")
@NamedQueries({
    
    @NamedQuery(
            name="encontrarEventoMenorFechaInscripcion", query="SELECT te FROM TiendaEvento te WHERE fechaInscripcion<:fechaInscripcion"
    ),
    
    @NamedQuery(
            name="encontrarEventoMayorFechaInscripcion", query="SELECT te FROM TiendaEvento te WHERE fechaInscripcion>:fechaInscripcion"
    ),
    
    @NamedQuery(
            name="encontrarEventoEntreFechaInscripcion", query="SELECT te FROM TiendaEvento te WHERE fechaInscripcion<=:fechaInscripcionMin and fechaInscripcion>=:fechaInscripcionMax"
    ),
    
})
@XmlRootElement
public class TiendaEvento implements Serializable {
    @EmbeddedId
    private TiendaEventoId idTienEven;
   // @JsonIgnore
    @MapsId("idTienda")
    @ManyToOne
    private Tienda tienda;
    
   // @JsonIgnore
    @MapsId("idEvento")
    @ManyToOne
    private Evento evento;
    
    private Date fechaInscripcion;

    public TiendaEventoId getIdTienEven() {
        return idTienEven;
    }

    public void setIdTienEven(TiendaEventoId idTienEven) {
        this.idTienEven = idTienEven;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

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
        hash = 59 * hash + Objects.hashCode(this.idTienEven);
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
        if (!Objects.equals(this.idTienEven, other.idTienEven)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TiendaEvento{" + "idTienEven=" + idTienEven + ", tienda=" + tienda + ", evento=" + evento + ", fechaInscripcion=" + fechaInscripcion + '}';
    }

    
    
    
    
}
