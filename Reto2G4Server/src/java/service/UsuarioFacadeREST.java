/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import static encriptation.EnvioEmail.enviarEmail;
import static encriptation.Hash.hashText;
import static encriptation.Asimetrico.desencriptar;
import encriptation.EnvioEmail;
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
 * Servicio restful para la etnidad Usuario.
 *
 * @author David
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
    @Path("encontrarUsuarioCorreo/{correo}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Usuario encontrarUsuarioCorreo(@PathParam("correo") String correo) throws ReadException {
        return ejb.encontrarUsuarioCorreo(correo);
    }

    @GET
    @Path("iniciarSesion/{correo}/{password}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Usuario iniciarSesion(@PathParam("correo") String correo, @PathParam("password") String password) throws ReadException {
        String pass = desencriptar(password);
        String passHash = hashText(pass);
        Usuario usuario = ejb.iniciarSesion(correo, passHash);
        System.out.println(usuario.toString());
        return usuario;

    }

    @GET
    @Path("olvidarPasswd/{correo}")
    public void olvidarContrasenia(@PathParam("correo") String email) throws ReadException, UpdateException {
        Usuario u = encontrarUsuarioCorreo(email);

        if (u != null) {
            String pass = EnvioEmail.generateRandomPassword();
            u.setPassword(hashText(pass));
            edit(u.getIdUsuario(), u);

            String message = "Ésta es su nueva contraseña: " + pass;
            //enviarEmail(email, "Nueva contraseña", message);
        }
    }

    @GET
    @Path("cambiarPasswd/{correo}/{passwd}")
    public void cambiarContrasenia(@PathParam("correo") String email, @PathParam("passwd") String passwd) throws ReadException, UpdateException {
        Usuario u = encontrarUsuarioCorreo(email);

        if (u != null) {
            u.setPassword(hashText(desencriptar(passwd)));
            edit(u.getIdUsuario(), u);

            String message = "El cambio de contraseña se ha completado con exito";
            // enviarEmail(email, "Cambio de contraseña", message);
        }
    }
}
