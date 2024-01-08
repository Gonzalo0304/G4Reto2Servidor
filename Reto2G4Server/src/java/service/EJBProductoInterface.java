/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Producto;
import java.util.List;
import javax.ws.rs.PathParam;

/**
 *
 * @author Gonzalo
 */
public interface EJBProductoInterface{
    
    public void createProducto(Producto entity);

    public void editProducto(Producto entity);

    public void removeProducto(Producto entity);

    public Producto findProducto(Integer id);

    public List<Producto> findAllProducto();

    public List<Producto> findMaxAlturaProducto(Float altura);
    
    public List<Producto> findMinAlturaProducto(Float altura); 
    
    public List<Producto> findEntreAlturaProducto(Float from, Float to);
    
    public List<Producto> findMaxPrecioProducto(Float altura);
    
    public List<Producto> findMinPrecioProducto(Float altura); 
    
    public List<Producto> findEntrePrecioProducto(Float from, Float to);
    
    public List<Producto> findMaxPesoProducto(Float altura);
    
    public List<Producto> findMinPesoProducto(Float altura); 
    
    public List<Producto> findEntrePesoProducto(Float from, Float to);
    
}
