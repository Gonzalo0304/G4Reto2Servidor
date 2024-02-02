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

/**
 *
 * Interfaz que define las operaciones CRUD para la entidad Producto.
 *
 * @author Gonzalo
 */
public interface EJBProductoInterface {

    public void createProducto(Producto entity) throws CreateException;

    public void editProducto(Producto entity) throws UpdateException;

    public void removeProducto(Producto entity) throws DeleteException;

    public Producto findProducto(Integer id) throws ReadException;

    public List<Producto> findAllProducto() throws ReadException;

    public List<Producto> encontrarProductoTodosTienda(int idTienda) throws ReadException;

    public List<Producto> findMaxAlturaProducto(int altura, int idTienda) throws ReadException;

    public List<Producto> findMinAlturaProducto(int altura, int idTienda) throws ReadException;

    public List<Producto> findEntreAlturaProducto(int from, int to, int idTienda) throws ReadException;

    public List<Producto> findMaxPrecioProducto(Float altura, int idTienda) throws ReadException;

    public List<Producto> findMinPrecioProducto(Float altura, int idTienda) throws ReadException;

    public List<Producto> findEntrePrecioProducto(Float from, Float to, int idTienda) throws ReadException;

    public List<Producto> findMaxPesoProducto(Float altura, int idTienda) throws ReadException;

    public List<Producto> findMinPesoProducto(Float altura, int idTienda) throws ReadException;

    public List<Producto> findEntrePesoProducto(Float from, Float to, int idTienda) throws ReadException;

}
