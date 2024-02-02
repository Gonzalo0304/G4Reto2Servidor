/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * Clase que representa la clave primaria compuesta para la entidad
 * TiendaEvento. Esta clase se utiliza para almacenar los identificadores de la
 * tienda y el evento que forman la clave primaria de la relación TiendaEvento.
 *
 * @author David
 */
@Embeddable
public class TiendaEventoId implements Serializable {

    private int idTienda;
    private int idEvento;

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    @Override
    public String toString() {
        return "TiendaEventoId{" + "idTienda=" + idTienda + ", idEvento=" + idEvento + '}';
    }

}
