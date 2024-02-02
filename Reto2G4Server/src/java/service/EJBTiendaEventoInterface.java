package service;

import entities.TiendaEvento;
import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.ReadException;
import exceptions.UpdateException;
import java.util.List;

/**
 *
 * Interfaz que define operaciones CRUD para la entidad TiendaEvento.
 * Proporciona métodos para crear, actualizar, eliminar y recuperar asociaciones
 * entre tiendas y eventos. Además, incluye operaciones para buscar una
 * asociación específica por sus IDs y obtener todas las asociaciones.
 *
 *
 * @author Iñigo y David
 */
public interface EJBTiendaEventoInterface {

    public void createTiendaEvento(TiendaEvento tiendaEvento) throws CreateException;

    public void editTiendaEvento(TiendaEvento tienda) throws UpdateException;

    public void deleteTiendaEvento(TiendaEvento tienda) throws DeleteException;

    public TiendaEvento encontrarTiendaEvento(Integer tienda_id, Integer evento_id) throws ReadException;

    public List<TiendaEvento> encontrarTodosTiendaEvento() throws ReadException;

}
