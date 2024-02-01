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
@Path("entities.tienda")
public class TiendaFacadeREST {

    @EJB
    private EJBTiendaInterface ti;

    public TiendaFacadeREST() {

    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Tienda tienda) throws CreateException {
        ti.createTienda(tienda);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Tienda tienda) throws UpdateException {
        ti.editTienda(tienda);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) throws ReadException, DeleteException {
        System.out.println(id);
        Tienda tienda = ti.encontrarTiendaId(id);
        System.out.println("Tienda antes de ser eliminada" + tienda.toString());
        ti.deleteTienda(tienda);
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Tienda find(@PathParam("id") Integer id) throws ReadException {
        return ti.encontrarTiendaId(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Tienda> findAll() throws ReadException {
        return ti.findAll();
    }

    @GET
    @Path("encontrarTiendaMenorEspacio/{espacio}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Tienda> encontrarTiendaMenorEspacio(@PathParam("espacio") Float espacio) throws ReadException {
        return ti.encontrarTiendaMenorEspacio(espacio);
    }

    @GET
    @Path("encontrarTiendaMayorEspacio/{espacio}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Tienda> encontrarTiendaMayorEspacio(@PathParam("espacio") Float espacio) throws ReadException {
        return ti.encontrarTiendaMayorEspacio(espacio);
    }

    @GET
    @Path("encontrarTiendaEntreEspacio/{espacioMin}/{espacioMax}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Tienda> encontrarTiendaEntreEspacio(@PathParam("espacioMin") Float espacioMin, @PathParam("espacioMax") Float espacioMax) throws ReadException {
        return ti.encontrarTiendaEntreEspacio(espacioMin, espacioMax);
    }

    @GET
    @Path("encontrarTiendaTipoPago/{tipoPago}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Tienda> encontrarTiendaTipoPago(@PathParam("tipoPago") TipoPago tipoPago) throws ReadException {
        return ti.encontrarTiendaTipoPago(tipoPago);
    }

}
