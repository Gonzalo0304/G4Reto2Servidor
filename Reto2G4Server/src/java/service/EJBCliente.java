/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Tienda;
import entities.Cliente;
import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.ReadException;
import exceptions.UpdateException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author David
 */
public class EJBCliente implements EJBClienteInterface {

    @PersistenceContext(unitName = "Reto2G4ServerPU")
    private EntityManager em;

    @Override
    public void createCliente(Cliente cliente) throws CreateException {
        try {
            em.persist(cliente);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void editCliente(Cliente cliente) throws UpdateException {
        try {
            if (!em.contains(cliente)) {
                em.merge(cliente);
            }
            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

    @Override
    public void deleteCliente(Cliente cliente) throws DeleteException {
        try {
            em.remove(cliente);
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public List<Cliente> findAll() throws ReadException {
        ArrayList<Cliente> clientes;
        try {
            clientes = (ArrayList<Cliente>) em.createNamedQuery("Tienda.encontrarTodasTiendas");
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return clientes;
    }

    @Override
    public List<Cliente> encontrarClienteMenorFechaNac() throws ReadException {
        ArrayList<Cliente> clientes;
        try {
            clientes = (ArrayList<Cliente>) em.createNamedQuery("Tienda.encontrarClienteMenorFechaNac");
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return clientes;
    }

    @Override
    public List<Cliente> encontrarClienteMayorFechaNac() throws ReadException {
        ArrayList<Cliente> clientes;
        try {
            clientes = (ArrayList<Cliente>) em.createNamedQuery("Tienda.encontrarClienteMayorFechaNac");
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return clientes;
    }

    @Override
    public List<Cliente> encontrarClienteEntreFechaNac() throws ReadException {
        ArrayList<Cliente> clientes;
        try {
            clientes = (ArrayList<Cliente>) em.createNamedQuery("Tienda.encontrarClienteEntreFechaNac");
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return clientes;
    }

    @Override
    public List<Cliente> encontrarClienteMayorNumEventos() throws ReadException {
        ArrayList<Cliente> clientes;
        try {
            clientes = (ArrayList<Cliente>) em.createNamedQuery("Tienda.encontrarClienteMayorNumEventos");
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return clientes;
    }

    @Override
    public List<Cliente> encontrarClienteMenorNumEventos() throws ReadException {
        ArrayList<Cliente> clientes;
        try {
            clientes = (ArrayList<Cliente>) em.createNamedQuery("Tienda.encontrarClienteMenorNumEventos");
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return clientes;
    }

    @Override
    public List<Cliente> encontrarClienteEntreNumEventos() throws ReadException {
        ArrayList<Cliente> clientes;
        try {
            clientes = (ArrayList<Cliente>) em.createNamedQuery("Tienda.encontrarClienteEntreNumEventos");
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return clientes;
    }

    @Override
    public List<Cliente> encontrarClienteSegunTipoVenta() throws ReadException {
        ArrayList<Cliente> clientes;
        try {
            clientes = (ArrayList<Cliente>) em.createNamedQuery("Tienda.encontrarClienteSegunTipoVenta");
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return clientes;
    }

}
