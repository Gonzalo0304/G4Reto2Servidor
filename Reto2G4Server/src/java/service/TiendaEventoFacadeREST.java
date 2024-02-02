/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.TiendaEvento;
import entities.TiendaEventoId;
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
import javax.ws.rs.core.PathSegment;

/**
 *
 * Clase que expone servicios RESTful para la entidad TiendaEvento. Permite
 * realizar operaciones CRUD (Create, Read, Update, Delete) sobre los datos de
 * TiendaEvento. Los métodos de esta clase gestionan las solicitudes HTTP y
 * llaman a los métodos correspondientes en la interfaz
 * EJBTiendaEventoInterface. La ruta base para estos servicios es
 * "entities.tienda_evento".
 *
 * @author David
 */
@Stateless
@Path("entities.tienda_evento")
public class TiendaEventoFacadeREST {

    @EJB
    private EJBTiendaEventoInterface ejb;

    private TiendaEventoId getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idTienda=idTiendaValue;idEvento=idEventoValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        entities.TiendaEventoId key = new entities.TiendaEventoId();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idTienda = map.get("idTienda");
        if (idTienda != null && !idTienda.isEmpty()) {
            key.setIdTienda(new java.lang.Integer(idTienda.get(0)));
        }
        java.util.List<String> idEvento = map.get("idEvento");
        if (idEvento != null && !idEvento.isEmpty()) {
            key.setIdEvento(new java.lang.Integer(idEvento.get(0)));
        }
        return key;
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(TiendaEvento entity) throws CreateException {
        System.out.println("Creando TiendaEvento --> " + entity.toString());
        ejb.createTiendaEvento(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, TiendaEvento entity) throws UpdateException {
        ejb.editTiendaEvento(entity);
    }

    @DELETE
    @Path("{tienda_id}/{evento_id}")
    public void remove(@PathParam("tienda_id") Integer tienda_id, @PathParam("evento_id") Integer evento_id) throws DeleteException, ReadException {
        ejb.deleteTiendaEvento(this.find(tienda_id, evento_id));
    }

    @GET
    @Path("{tienda_id}/{evento_id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public TiendaEvento find(@PathParam("tienda_id") Integer tienda_id, @PathParam("evento_id") Integer evento_id) throws ReadException {
        return ejb.encontrarTiendaEvento(tienda_id, evento_id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<TiendaEvento> findAll() throws ReadException {
        System.out.println("FINDALL TIENDA EVENTO");
        return ejb.encontrarTodosTiendaEvento();
    }

}
