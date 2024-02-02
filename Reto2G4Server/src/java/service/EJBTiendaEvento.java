package service;

import entities.TiendaEvento;
import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.ReadException;
import exceptions.UpdateException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * EJB que implementa la interfaz EJBTiendaEventoInterface para realizar
 * operaciones CRUD relacionadas con la entidad TiendaEvento.
 *
 * @author Iñigo y David
 */
@Stateless
public class EJBTiendaEvento implements EJBTiendaEventoInterface {

    @PersistenceContext(unitName = "Reto2G4ServerPU")
    private EntityManager em;

    @Override
    public void createTiendaEvento(TiendaEvento tiendEvento) throws CreateException {
        System.out.println("Creando TiendaEvento --> " + tiendEvento.toString());
        try {
            if (!em.contains(tiendEvento.getTienda())) {
                tiendEvento.setTienda(em.merge(tiendEvento.getTienda()));
            }

            if (!em.contains(tiendEvento.getEvento())) {
                tiendEvento.setEvento(em.merge(tiendEvento.getEvento()));
            }
            em.persist(tiendEvento);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }

    }

    @Override
    public void editTiendaEvento(TiendaEvento tienda) throws UpdateException {
        try {
            if (!em.contains(tienda)) {
                em.merge(tienda);
            }
            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

    @Override
    public void deleteTiendaEvento(TiendaEvento tienda) throws DeleteException {
        try {
            em.remove(tienda);
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public TiendaEvento encontrarTiendaEvento(Integer tienda_id, Integer evento_id) throws ReadException {
        TiendaEvento tienda;
        try {
            tienda = (TiendaEvento) em.createNamedQuery("encontrarTiendaEvento").setParameter("idTienda", tienda_id).setParameter("idEvento", evento_id).getSingleResult();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return tienda;
    }

    @Override
    public List<TiendaEvento> encontrarTodosTiendaEvento() throws ReadException {
        List<TiendaEvento> tienda;
        try {
            tienda = em.createNamedQuery("encontrarTodosTiendaEvento").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return tienda;
    }

}
