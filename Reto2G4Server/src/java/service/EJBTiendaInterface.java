/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Evento;
import entities.Tienda;
import entities.TipoPago;
import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.ReadException;
import exceptions.UpdateException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author David
 */
public interface EJBTiendaInterface {
    
    public void createTienda(Tienda tienda) throws CreateException;
    
    public void editTienda(Tienda tienda) throws UpdateException;
    
    public void deleteTienda(Tienda tienda) throws DeleteException;
    
    public List<Tienda> findAll() throws ReadException;
    
    public List<Tienda> encontrarTiendaMenorEspacio(Float espacio) throws ReadException;
    
    public List<Tienda> encontrarTiendaMayorEspacio(Float espacio) throws ReadException;
    
    public List<Tienda> encontrarTiendaEntreEspacio(Float minEspacio, Float maxEspacio) throws ReadException;
    
    public List<Tienda> encontrarTiendaAnteriorFecha(Date fecha) throws ReadException;
    
    public List<Tienda> encontrarTiendaPostiorFecha(Date fecha) throws ReadException;
    
    public List<Tienda> encontrarTiendaEntreFecha(Date minFecha, Date maxFecha) throws ReadException;
    
    public List<Tienda> encontrarTiendaTipoPago(TipoPago tipoPago) throws ReadException;
    
}
