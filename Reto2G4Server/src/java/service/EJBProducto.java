/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Cliente;
import entities.Producto;
import entities.Tienda;
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
 * EJB para la gestión de productos. Proporciona métodos para realizar
 * operaciones CRUD en la entidad Producto.
 *
 *
 * @author Gonzalo
 */
@Stateless
public class EJBProducto implements EJBProductoInterface {

    @PersistenceContext(unitName = "Reto2G4ServerPU")
    private EntityManager em;

    @Override
    public void createProducto(Producto producto) throws CreateException {
        try {
            em.merge(producto);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void editProducto(Producto producto) throws UpdateException {
        try {
            if (!em.contains(producto)) {
                em.merge(producto);
            }
            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

    @Override
    public void removeProducto(Producto producto) throws DeleteException {
        try {
            System.out.println("Eliminando el siguiente producto --> " + producto.toString());

            if (producto.getCliente() != null) {
                Cliente c = producto.getCliente();
                List<Producto> productosCliente = c.getProductosCreados();
                productosCliente.remove(producto);
                c.setProductosCreados(productosCliente);
                em.merge(c);
            }

            if (producto.getTienda() != null) {
                Tienda t = producto.getTienda();
                List<Producto> productosTienda = t.getProductos();
                productosTienda.remove(producto);
                t.setProductos(productosTienda);
                em.merge(t);
            }

            producto = em.merge(producto);
            em.remove(producto);
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public Producto findProducto(Integer id) throws ReadException {
        Producto producto;
        try {
            producto = em.find(Producto.class, id);
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return producto;

    }

    @Override
    public List<Producto> findAllProducto() throws ReadException {
        List<Producto> productos;

        try {
            productos = em.createNamedQuery("encontrarProductoTodos").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return productos;
    }

    @Override
    public List<Producto> encontrarProductoTodosTienda(int idTienda) throws ReadException {
        List<Producto> productos;

        try {
            productos = em.createNamedQuery("encontrarProductoTodosTienda").setParameter("idTienda", idTienda).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return productos;
    }

    @Override
    public List<Producto> findMaxAlturaProducto(int altura, int idTienda) throws ReadException {
        List<Producto> productos;

        try {
            productos = em.createNamedQuery("encontrarProductoMayorAltura").setParameter("altura", altura).setParameter("idTienda", idTienda).getResultList();

        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return productos;
    }

    @Override
    public List<Producto> findMinAlturaProducto(int altura, int idTienda) throws ReadException {
        List<Producto> productos;

        try {
            productos = em.createNamedQuery("encontrarProductoMenorAltura").setParameter("altura", altura).setParameter("idTienda", idTienda).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return productos;
    }

    @Override
    public List<Producto> findEntreAlturaProducto(int from, int to, int idTienda) throws ReadException {
        List<Producto> productos;

        try {
            productos = em.createNamedQuery("encontrarProductoEntreAltura").setParameter("alturaMin", from).setParameter("alturaMax", to).setParameter("idTienda", idTienda).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return productos;
    }

    @Override
    public List<Producto> findMaxPrecioProducto(Float precio, int idTienda) throws ReadException {
        List<Producto> productos;

        try {
            productos = em.createNamedQuery("encontrarProductoMayorPrecio").setParameter("precio", precio).setParameter("idTienda", idTienda).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return productos;
    }

    @Override
    public List<Producto> findMinPrecioProducto(Float precio, int idTienda) throws ReadException {
        List<Producto> productos;

        try {
            productos = em.createNamedQuery("encontrarProductoMenorPrecio").setParameter("precio", precio).setParameter("idTienda", idTienda).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return productos;
    }

    @Override
    public List<Producto> findEntrePrecioProducto(Float from, Float to, int idTienda) throws ReadException {
        List<Producto> productos;

        try {
            productos = em.createNamedQuery("encontrarProductoEntrePrecio").setParameter("precioMin", from).setParameter("precioMax", to).setParameter("idTienda", idTienda).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return productos;
    }

    @Override
    public List<Producto> findMaxPesoProducto(Float peso, int idTienda) throws ReadException {
        List<Producto> productos;

        try {
            productos = em.createNamedQuery("encontrarProductoMayorPeso").setParameter("peso", peso).setParameter("idTienda", idTienda).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return productos;
    }

    @Override
    public List<Producto> findMinPesoProducto(Float peso, int idTienda) throws ReadException {
        List<Producto> productos;

        try {
            productos = em.createNamedQuery("encontrarProductoMenorPeso").setParameter("peso", peso).setParameter("idTienda", idTienda).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return productos;
    }

    @Override
    public List<Producto> findEntrePesoProducto(Float from, Float to, int idTienda) throws ReadException {
        List<Producto> productos;

        try {
            productos = em.createNamedQuery("encontrarProductoEntrePeso").setParameter("pesoMin", from).setParameter("pesoMax", to).setParameter("idTienda", idTienda).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return productos;
    }

}
