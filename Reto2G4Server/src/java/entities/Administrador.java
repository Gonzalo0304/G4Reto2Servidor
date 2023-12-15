/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * Clase que representa a un administrador en MarketMakers. Hereda de la clase
 * base Usuario. Contiene información específica de los administradores, como el
 * número de eventos que han creado y administrado.
 *
 * @author inigo
 */
@Entity
public class Administrador extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int numEventos;

    /**
     * Relación One-to-Many que representa los eventos gestionados por este
     * administrador. El campo 'administrador' en la clase Evento establece la
     * relación inversa. Se utiliza la estrategia CascadeType.ALL para aplicar
     * operaciones en cascada, y FetchType.LAZY para cargar la lista de eventos
     * solo cuando sea necesario.
     */
    @OneToMany(mappedBy = "administrador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Evento> eventos = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entitys.Administrador[ id=" + id + " ]";
    }

}
