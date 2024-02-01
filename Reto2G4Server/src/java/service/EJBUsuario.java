/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Administrador;
import entities.Cliente;
import entities.TipoVenta;
import entities.Usuario;
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
public class EJBUsuario implements EJBUsuarioInterface {

    @PersistenceContext(unitName = "Reto2G4ServerPU")
    private EntityManager em;

    @Override
    public void createUsuario(Usuario usuario) throws CreateException {
        try {
            em.persist(usuario);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void createCliente(Cliente cliente) throws CreateException {
        try {
            System.out.println("Creando el siguiente cliente --> " + cliente.toString());
            em.persist(cliente);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void createAdmin(Administrador admin) throws CreateException {
        try {
            em.persist(admin);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void editUsuario(Usuario usuario) throws UpdateException {
        try {
            if (!em.contains(usuario)) {
                em.merge(usuario);
            }
            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

    @Override
    public void editCliente(Cliente cliente) throws UpdateException {
        System.out.println(cliente.toString());
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
    public void editAdmin(Administrador admin) throws UpdateException {
        try {
            if (!em.contains(admin)) {
                em.merge(admin);
            }
            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

    @Override
    public void deleteUsuario(Usuario usuario) throws DeleteException {
        try {
            em.remove(usuario);
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public List<Usuario> findAll() throws ReadException {
        List<Usuario> clientes;
        try {
            clientes = em.createNamedQuery("encontrarTodosUsuarios").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return clientes;
    }

    @Override
    public Usuario encontrarUsuarioCorreo(String correo) throws ReadException {
        Usuario usuario;
        try {
            usuario = (Usuario) em.createNamedQuery("encontrarUsuarioCorreo").setParameter("correo", correo).getSingleResult();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return usuario;
    }

    @Override
    public Usuario encontrarUsuarioId(int id) throws ReadException {
        Usuario cliente;
        try {
            cliente = em.find(Usuario.class, id);
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return cliente;
    }

    @Override
    public Usuario encontrarClienteId(int id) throws ReadException {
        Usuario cliente;
        try {
            cliente = em.find(Cliente.class, id);
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return cliente;
    }

    @Override
    public Usuario encontrarAdminId(int id) throws ReadException {
        Usuario admin;
        try {
            admin = em.find(Administrador.class, id);
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return admin;
    }

    @Override
    public List<Usuario> encontrarUsuarioPorTipoVenta(TipoVenta tipoVenta) throws ReadException {
        List<Usuario> clientes;
        try {
            clientes = em.createNamedQuery("encontrarUsuarioPorTipoVenta").setParameter("tipoVenta", tipoVenta).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return clientes;
    }

    @Override
    public List<Usuario> encontrarUsuarioPorNombre(String nombre) throws ReadException {
        List<Usuario> clientes;
        try {
            clientes = em.createNamedQuery("encontrarUsuarioPorNombre").setParameter("nombre", "%" + nombre + "%").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return clientes;
    }

    @Override
    public List<Usuario> encontrarUsuarioPorMinNumeroEventos(int numEventos) throws ReadException {
        List<Usuario> usuarios;
        try {
            usuarios = em.createNamedQuery("encontrarUsuarioPorMinNumeroEventos").setParameter("numEventos", numEventos).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return usuarios;
    }

    @Override
    public List<Usuario> encontrarUsuarioPorMaxNumeroEventos(int numEventos) throws ReadException {
        List<Usuario> usuarios;
        try {
            usuarios = em.createNamedQuery("encontrarUsuarioPorMaxNumeroEventos").setParameter("numEventos", numEventos).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return usuarios;
    }

    @Override
    public List<Cliente> encontrarTodosClientes() throws ReadException {

        List<Cliente> clientes;
        try {
            clientes = em.createNamedQuery("encontrarTodosClientes").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return clientes;
    }

    @Override
    public List<Administrador> encontrarTodosAdmins() throws ReadException {
        List<Administrador> administradores;
        try {
            administradores = em.createNamedQuery("encontrarTodosAdmins").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return administradores;
    }

    @Override
    public Usuario iniciarSesion(String correo, String password) throws ReadException {
        Usuario usuario;
        try {
            usuario = (Usuario) em.createNamedQuery("iniciarSesion").setParameter("correo", correo).setParameter("password", password).getSingleResult();

        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return usuario;
    }

}
