/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Tienda;
import entities.TipoPago;
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
 * @author David
 */
@Stateless
public class EJBTienda implements EJBTiendaInterface {

    @PersistenceContext(unitName = "Reto2G4ServerPU")
    private EntityManager em;

    @Override
    public void createTienda(Tienda tienda) throws CreateException {
        try {
            em.persist(tienda);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }

    }

    @Override
    public void editTienda(Tienda tienda) throws UpdateException {
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
    public void deleteTienda(Tienda tienda) throws DeleteException {
        try {
            em.remove(tienda);
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public Tienda encontrarTiendaId(int id) throws ReadException {
        Tienda tienda;
        try {
            tienda = em.find(Tienda.class, id);
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return tienda;
    }

    @Override
    public List<Tienda> findAll() throws ReadException {
        List<Tienda> tiendas;
        try {
            tiendas = em.createNamedQuery("encontrarTodasTiendas").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return tiendas;
    }

    @Override
    public List<Tienda> encontrarTiendaMenorEspacio(Float espacio) throws ReadException {
        List<Tienda> tiendas;
        try {
            tiendas = em.createNamedQuery("encontrarTiendaMenorEspacio").setParameter("espacio", espacio).getResultList();;
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return tiendas;
    }

    @Override
    public List<Tienda> encontrarTiendaMayorEspacio(Float espacio) throws ReadException {
        List<Tienda> tiendas;
        try {
            tiendas = em.createNamedQuery("encontrarTiendaMayorEspacio").setParameter("espacio", espacio).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return tiendas;
    }

    @Override
    public List<Tienda> encontrarTiendaEntreEspacio(Float espacioMin, Float espacioMax) throws ReadException {
        List<Tienda> tiendas;
        try {
            tiendas = em.createNamedQuery("encontrarTiendaEntreEspacio").setParameter("espacioMin", espacioMin).setParameter("espacioMax", espacioMax).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return tiendas;
    }

    @Override
    public List<Tienda> encontrarTiendaTipoPago(TipoPago tipoPago) throws ReadException {
        List<Tienda> tiendas;
        try {
            tiendas = em.createNamedQuery("encontrarTiendaTipoPago").setParameter("tipoPago", tipoPago).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return tiendas;
    }

}
