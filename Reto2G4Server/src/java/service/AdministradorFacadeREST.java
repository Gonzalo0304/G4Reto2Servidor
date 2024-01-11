/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Administrador;
import entities.Usuario;
import entities.Tienda;
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
@Path("entities.administrador")
public class AdministradorFacadeREST {

    @EJB
    private EJBUsuarioInterface ci;

    public AdministradorFacadeREST() {

    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Administrador admin) throws CreateException {
        ci.createAdmin(admin);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") int id, Administrador admin) throws UpdateException {
        ci.editAdmin(admin);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) throws ReadException, DeleteException {
        Usuario usuario = ci.encontrarUsuarioId(id);
        ci.deleteUsuario(usuario);
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Usuario find(@PathParam("id") Integer id) throws ReadException {
        return ci.encontrarAdminId(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Administrador> findAll() throws ReadException {
        return ci.encontrarTodosAdmins();

    }

    @GET
    @Path("encontrarUsuarioPorMinNumeroEventos/{numEventos}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usuario> encontrarUsuarioPorMinNumeroEventos(@PathParam("numEventos") int numEventos) throws ReadException {
        return ci.encontrarUsuarioPorMinNumeroEventos(numEventos);

    }

    @GET
    @Path("encontrarUsuarioPorMaxNumeroEventos/{numEventos}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usuario> encontrarUsuarioPorMaxNumeroEventos(@PathParam("numEventos") int numEventos) throws ReadException {
        return ci.encontrarUsuarioPorMaxNumeroEventos(numEventos);

    }

}
