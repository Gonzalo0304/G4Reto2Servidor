package service;

import entities.TiendaEvento;
import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.ReadException;
import exceptions.UpdateException;
import java.util.List;

/**
 *
 * @author Jason.
 */
public interface EJBTiendaEventoInterface {

    public void createTiendaEvento(TiendaEvento tiendaEvento) throws CreateException;

    public void editTiendaEvento(TiendaEvento tienda) throws UpdateException;

    public void deleteTiendaEvento(TiendaEvento tienda) throws DeleteException;

    public TiendaEvento encontrarTiendaEvento(Integer tienda_id, Integer evento_id) throws ReadException;

    public List<TiendaEvento> encontrarTodosTiendaEvento() throws ReadException;

}
