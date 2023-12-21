/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Evento;
import entities.Tienda;
import entities.TipoPago;
import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.ReadException;
import exceptions.UpdateException;
import java.util.ArrayList;
import java.util.Date;
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
    public List<Tienda> findAll() throws ReadException {
        ArrayList<Tienda> tiendas;
        try {
            tiendas = (ArrayList<Tienda>) em.createNamedQuery("Tienda.encontrarTodasTiendas");
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return tiendas;
    }

    @Override
    public List<Tienda> encontrarTiendaMenorEspacio(Float espacio) throws ReadException {
        ArrayList<Tienda> tiendas;
        try {
            tiendas = (ArrayList<Tienda>) em.createNamedQuery("Tienda.encontrarTiendaMenorEspacio");
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return tiendas;
    }

    @Override
    public List<Tienda> encontrarTiendaMayorEspacio(Float espacio) throws ReadException {
        ArrayList<Tienda> tiendas;
        try {
            tiendas = (ArrayList<Tienda>) em.createNamedQuery("Tienda.encontrarTiendaMayorEspacio");
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return tiendas;
    }

    @Override
    public List<Tienda> encontrarTiendaEntreEspacio(Float minEspacio, Float maxEspacio) throws ReadException {
        ArrayList<Tienda> tiendas;
        try {
            tiendas = (ArrayList<Tienda>) em.createNamedQuery("Tienda.encontrarTiendaEntreEspacio");
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return tiendas;
    }

    @Override
    public List<Tienda> encontrarTiendaAnteriorFecha(Date fecha) throws ReadException {
        ArrayList<Tienda> tiendas;
        try {
            tiendas = (ArrayList<Tienda>) em.createNamedQuery("Tienda.encontrarTiendaAnteriorFecha");
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return tiendas;
    }

    @Override
    public List<Tienda> encontrarTiendaPostiorFecha(Date fecha) throws ReadException {
        ArrayList<Tienda> tiendas;
        try {
            tiendas = (ArrayList<Tienda>) em.createNamedQuery("Tienda.encontrarTiendaPostiorFecha");
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return tiendas;
    }

    @Override
    public List<Tienda> encontrarTiendaEntreFecha(Date minFecha, Date maxFecha) throws ReadException {
        ArrayList<Tienda> tiendas;
        try {
            tiendas = (ArrayList<Tienda>) em.createNamedQuery("Tienda.encontrarTiendaEntreFecha");
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return tiendas;
    }

    @Override
    public List<Tienda> encontrarTiendaTipoPago(TipoPago tipoPago) throws ReadException {
        ArrayList<Tienda> tiendas;
        try {
            tiendas = (ArrayList<Tienda>) em.createNamedQuery("Tienda.encontrarTiendaTipoPago");
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return tiendas;
    }

}
