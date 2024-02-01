/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Producto;
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
 * @author Gonzalo
 */
@Stateless
@Path("entities.producto")
public class ProductoFacadeREST {

    @EJB
    private EJBProductoInterface ejb;

    public ProductoFacadeREST() {

    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Producto producto) throws CreateException {
        System.out.println("Creando el siguiente producto --> " + producto.toString());
        System.out.println("Su cliente --> " + producto.getCliente());
        System.out.println("Su Tienda --> " + producto.getTienda());
        ejb.createProducto(producto);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Producto producto) throws UpdateException {
        ejb.editProducto(producto);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) throws ReadException, DeleteException {
        ejb.removeProducto(ejb.findProducto(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Producto find(@PathParam("id") Integer id) throws ReadException {
        return ejb.findProducto(id);

    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> findAll() throws ReadException {
        return ejb.findAllProducto();

    }

    @GET
    @Path("encontrarProductoTodosTienda/{idTienda}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> encontrarProductoTodosTienda(@PathParam("idTienda") int idTienda) throws ReadException {
        return ejb.encontrarProductoTodosTienda(idTienda);

    }

    @GET
    @Path("encontrarProductoMayorAltura/{altura}/{idTienda}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> findMaxAlturaProducto(@PathParam("altura") int altura, @PathParam("idTienda") int idTienda) throws ReadException {
        return ejb.findMaxAlturaProducto(altura, idTienda);
    }

    @GET
    @Path("encontrarProductoMenorAltura/{altura}/{idTienda}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> findMinAlturaProducto(@PathParam("altura") int altura, @PathParam("idTienda") int idTienda) throws ReadException {
        return ejb.findMinAlturaProducto(altura, idTienda);
    }

    @GET
    @Path("encontrarProductoEntreAltura/{altura1}/{altura2}/{idTienda}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> findEntreAlturaProducto(@PathParam("altura1") int altura1, @PathParam("altura2") int altura2, @PathParam("idTienda") int idTienda) throws ReadException {
        return ejb.findEntreAlturaProducto(altura1, altura2, idTienda);
    }

    @GET
    @Path("encontrarProductoMayorPrecio/{precio}/{idTienda}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> encontrarProductoMayorPrecio(@PathParam("precio") Float precio, @PathParam("idTienda") int idTienda) throws ReadException {
        return ejb.findMaxPrecioProducto(precio, idTienda);
    }

    @GET
    @Path("encontrarProductoMenorPrecio/{precio}/{idTienda}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> encontrarProductoMenorPrecio(@PathParam("precio") Float precio, @PathParam("idTienda") int idTienda) throws ReadException {
        return ejb.findMinPrecioProducto(precio, idTienda);
    }

    @GET
    @Path("encontrarProductoEntrePrecio/{precio1}/{precio2}/{idTienda}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> findEntrePrecioProducto(@PathParam("precio1") Float precio1, @PathParam("precio2") Float precio2, @PathParam("idTienda") int idTienda) throws ReadException {
        return ejb.findEntrePrecioProducto(precio1, precio2, idTienda);
    }

    @GET
    @Path("encontrarProductoMayorPeso/{peso}/{idTienda}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> findMaxPesoProducto(@PathParam("peso") Float peso, @PathParam("idTienda") int idTienda) throws ReadException {
        return ejb.findMaxPesoProducto(peso, idTienda);
    }

    @GET
    @Path("encontrarProductoMenorPeso/{peso}/{idTienda}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> findMinPesoProducto(@PathParam("peso") Float peso, @PathParam("idTienda") int idTienda) throws ReadException {
        return ejb.findMinPesoProducto(peso, idTienda);
    }

    @GET
    @Path("encontrarProductoEntrePesos/{peso1}/{peso2}/{idTienda}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> findEntrePesosProducto(@PathParam("peso1") Float peso1, @PathParam("peso2") Float peso2, @PathParam("idTienda") int idTienda) throws ReadException {
        return ejb.findEntrePesoProducto(peso1, peso2, idTienda);
    }

}
