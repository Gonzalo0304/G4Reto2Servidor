/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Cliente;
import entities.Usuario;
import entities.Tienda;
import entities.TipoVenta;
import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.ReadException;
import exceptions.UpdateException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author David
 */
@Stateless
@Path("entities.cliente")
public class ClienteFacadeREST {

    @EJB
    private EJBUsuarioInterface ci;

    public ClienteFacadeREST() {

    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Cliente cliente) throws CreateException {
        ci.createCliente(cliente);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") int id, Cliente cliente) throws UpdateException {
        ci.editCliente(cliente);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) throws ReadException, DeleteException {
        Usuario cliente = ci.encontrarUsuarioId(id);
        ci.deleteUsuario(cliente);
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Usuario find(@PathParam("id") Integer id) throws ReadException {
        return ci.encontrarClienteId(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> findAll() throws ReadException {
        return ci.encontrarTodosClientes();

    }

    @GET
    @Path("encontrarUsuarioPorTipoVenta/{tipoVenta}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usuario> encontrarUsuarioSegunTipoVenta(@PathParam("tipoVenta") TipoVenta tipoVenta) throws ReadException {
        return ci.encontrarUsuarioPorTipoVenta(tipoVenta);
    }
}
