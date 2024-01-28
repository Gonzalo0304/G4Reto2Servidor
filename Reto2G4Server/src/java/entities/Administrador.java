/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Clase que representa a un administrador en MarketMakers. Hereda de la clase
 * base Usuario. Contiene información específica de los administradores, como el
 * número de eventos que han creado y administrado.
 *
 * @author inigo
 */
@Entity
@DiscriminatorValue("Administrador")
@XmlRootElement
public class Administrador extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer numEventos;
    @ManyToMany(mappedBy = "administradores", fetch = FetchType.EAGER)
    private List<Evento> eventosOrganizados;

    public Integer getNumEventos() {
        return numEventos;
    }

    public void setNumEventos(Integer numEventos) {
        this.numEventos = numEventos;
    }

    public List<Evento> getEventosOrganizados() {
        return eventosOrganizados;
    }

    public void setEventosOrganizados(List<Evento> eventosOrganizados) {
        this.eventosOrganizados = eventosOrganizados;
    }

}
