/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Gonzalo
 */
@Stateless
public class EJBProducto implements EJBProductoInterface {

    @PersistenceContext(unitName = "Reto2G4ServerPU")
    private EntityManager em;

    @Override
    public void createProducto(Producto producto) {
        em.persist(producto);
    }

    @Override
    public void editProducto(Producto producto) {
        em.merge(producto);
        em.flush();
    }

    @Override
    public void removeProducto(Producto producto) {
        producto = em.merge(producto);
        em.remove(producto);
    }

    @Override
    public Producto findProducto(Integer id) {
        Producto producto = null;

        producto = em.find(Producto.class, id);

        return producto;
    }   

    @Override
    public List<Producto> findAllProducto() {
        List<Producto> productos = null;

        productos = em.createNamedQuery("encontrarProductoTodos").getResultList();

        return productos;
    }

    @Override
    public List<Producto> findMaxAlturaProducto(Float altura) {
        List<Producto> productos = null;
        productos = (ArrayList<Producto>) em.createNamedQuery("Producto.encontrarProductoMayorAltura");

        return productos;
    }

    @Override
    public List<Producto> findMinAlturaProducto(Float altura) {
        List<Producto> productos = null;
        productos = (ArrayList<Producto>) em.createNamedQuery("Producto.encontrarProductoMenorAltura");

        return productos;
    }

    @Override
    public List<Producto> findEntreAlturaProducto(Float from, Float to) {
        List<Producto> productos = null;
        productos = (ArrayList<Producto>) em.createNamedQuery("Producto.encontrarProductoEntreAltura");

        return productos;
    }

    @Override
    public List<Producto> findMaxPrecioProducto(Float altura) {
        List<Producto> productos = null;
        productos = (ArrayList<Producto>) em.createNamedQuery("Producto.encontrarProductoMayorrPrecio");

        return productos;
    }

    @Override
    public List<Producto> findMinPrecioProducto(Float altura) {
        List<Producto> productos = null;
        productos = (ArrayList<Producto>) em.createNamedQuery("Producto.encontrarProductoMenorPrecio");

        return productos;
    }

    @Override
    public List<Producto> findEntrePrecioProducto(Float from, Float to) {
        List<Producto> productos = null;
        productos = (ArrayList<Producto>) em.createNamedQuery("Producto.encontrarProductoEntrePrecio");

        return productos;
    }

    @Override
    public List<Producto> findMaxPesoProducto(Float altura) {
        List<Producto> productos = null;
        productos = (ArrayList<Producto>) em.createNamedQuery("Producto.encontrarProductoMenorPeso");

        return productos;
    }

    @Override
    public List<Producto> findMinPesoProducto(Float altura) {
        List<Producto> productos = null;
        productos = (ArrayList<Producto>) em.createNamedQuery("Producto.encontrarProductoMenorPeso");

        return productos;
    }

    @Override
    public List<Producto> findEntrePesoProducto(Float from, Float to) {
        List<Producto> productos = null;
        productos = (ArrayList<Producto>) em.createNamedQuery("Producto.encontrarProductoEntrePeso");

        return productos;
    }

}
