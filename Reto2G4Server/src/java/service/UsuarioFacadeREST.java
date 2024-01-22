/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import static encriptation.ServerEncriptacion.desencriptar;
import entities.Administrador;
import entities.Cliente;
import entities.Usuario;
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
@Path("entities.usuario")
public class UsuarioFacadeREST {

    @EJB
    private EJBUsuarioInterface ejb;

    public UsuarioFacadeREST() {

    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Usuario usuario) throws CreateException {
        ejb.createUsuario(usuario);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Usuario usuario) throws UpdateException {
        ejb.editUsuario(usuario);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) throws ReadException, DeleteException {
        ejb.deleteUsuario(ejb.encontrarUsuarioId(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Usuario find(@PathParam("id") Integer id) throws ReadException {
        return ejb.encontrarUsuarioId(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usuario> findAll() throws ReadException {
        return ejb.findAll();
    }

    @GET
    @Path("encontrarUsuarioPorNombre/{nombre}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usuario> encontrarUsuarioPorNombre(@PathParam("nombre") String nombre) throws ReadException {
        return ejb.encontrarUsuarioPorNombre(nombre);
    }

    @GET
    @Path("iniciarSesion/{correo}/{password}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Usuario iniciarSesion(@PathParam("correo") String correo, @PathParam("password") String password) throws ReadException {
        String pass = desencriptar(password);
        System.out.println(pass);
        Usuario usuario = ejb.iniciarSesion(correo, pass);
        Cliente cliente;
        Administrador admin;
        System.out.println(usuario.toString());
        if (usuario instanceof Cliente) {
            cliente = (Cliente) ejb.encontrarClienteId(usuario.getIdUsuario());
            System.out.println(cliente.toString());
            return cliente;
        } else {
            admin = (Administrador) ejb.encontrarAdminId(usuario.getIdUsuario());
            System.out.println(admin.toString());
            return admin;
        }

    }
}
