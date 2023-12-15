/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.Evento;
import entities.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * Clase que representa a un administrador en MarketMakers. Hereda de la clase
 * base Usuario. Contiene información específica de los administradores, como el
 * número de eventos que han creado y administrado.
 *
 * @author inigo
 */
@Entity
@DiscriminatorValue("A")
@XmlRootElement
public class Administrador extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    private int numEventos;
    @ManyToMany(mappedBy = "administradores", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Evento> eventosOrganizados;


    public int getNumEventos() {
        return numEventos;
    }

    public void setNumEventos(int numEventos) {
        this.numEventos = numEventos;
    }

    @XmlTransient
    public List<Evento> getEventosOrganizados() {
        return eventosOrganizados;
    }

    public void setEventosOrganizados(List<Evento> eventosOrganizados) {
        this.eventosOrganizados = eventosOrganizados;
    }

    @Override
    public String toString() {
        return super.toString() +"Administrador{" + "numEventos=" + numEventos + ", eventosOrganizados=" + eventosOrganizados + '}';
    }
}
