/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Producto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
@Path("entities.producto")
public class ProductoFacadeREST {

    @EJB
    private EJBProductoInterface ejb;

    public ProductoFacadeREST() {
        
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Producto entity) {
        ejb.createProducto(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Producto entity) {
        ejb.editProducto(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ejb.removeProducto(ejb.findProducto(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Producto find(@PathParam("id") Integer id) {
        Producto producto = null;
        
        producto=ejb.findProducto(id);
        
        return producto;
    }

    @GET
    @Path("findAll")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> findAll() {
        List<Producto> productos;
        
        return productos=ejb.findAllProducto();
       
    }

    @GET
    @Path("encontrarMaxAltura/{altura}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> findMaxAlturaProducto(Float altura) {
        List<Producto> productos;
        return productos = ejb.findMaxAlturaProducto(altura);
    }
    
    @GET
    @Path("encontrarMinAltura/{altura}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> findMinAlturaProducto(Float altura) {
        List<Producto> productos;
        return productos = ejb.findMinAlturaProducto(altura);
    }
    
    @GET
    @Path("encontrarEntreAltura/{altura1}/{altura2}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> findEntreAlturaProducto(@PathParam("altura1")Float altura1, @PathParam("altura2")Float altura2) {
        List<Producto> productos;
        return productos = ejb.findEntreAlturaProducto(altura1,altura2);
    }
    
    @GET
    @Path("encontrarMaxPrecio/{precio}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> findMaxPrecioProducto(Float precio) {
        List<Producto> productos;
        return productos = ejb.findMaxAlturaProducto(precio);
    }
    
    @GET
    @Path("encontrarMinPrecio/{precio}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> findMinPrecioProducto(Float precio) {
        List<Producto> productos;
        return productos = ejb.findMinAlturaProducto(precio);
    }
    
    @GET
    @Path("encontrarEntrePrecio/{precio1}/{precio2}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> findEntrePrecioProducto(@PathParam("precio1")Float precio1, @PathParam("precio2")Float precio2) {
        List<Producto> productos;
        return productos = ejb.findEntreAlturaProducto(precio1,precio2);
    }
    
    
    @GET
    @Path("encontrarMaxPeso/{peso}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> findMaxPesoProducto(Float peso) {
        List<Producto> productos;
        return productos = ejb.findMaxAlturaProducto(peso);
    }
    
    @GET
    @Path("encontrarMinPeso/{peso}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> findMinPesoProducto(Float peso) {
        List<Producto> productos;
        return productos = ejb.findMinAlturaProducto(peso);
    }
    
    @GET
    @Path("encontrarEntrePso/{peso1}/{peso2}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> findEntrePesosProducto(@PathParam("peso1")Float peso1, @PathParam("peso2")Float peso2) {
        List<Producto> productos;
        return productos = ejb.findEntreAlturaProducto(peso1,peso2);
    }      
    
    protected EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
