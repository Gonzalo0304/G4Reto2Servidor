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
import java.util.Date;
import java.util.List;

/**
 *
 * Interfaz que define operaciones CRUD para la entidad Tienda. Proporciona
 * métodos para crear, actualizar, eliminar y recuperar información sobre
 * tiendas. Además, incluye operaciones para buscar una tienda específica por su
 * ID, obtener todas las tiendas, buscar tiendas con un espacio menor, mayor o
 * entre un rango específico, y encontrar tiendas por tipo de pago.
 *
 *
 *
 * @author David
 */
public interface EJBTiendaInterface {

    public void createTienda(Tienda tienda) throws CreateException;

    public void editTienda(Tienda tienda) throws UpdateException;

    public void deleteTienda(Tienda tienda) throws DeleteException;

    public Tienda encontrarTiendaId(int id) throws ReadException;

    public List<Tienda> findAll() throws ReadException;

    public List<Tienda> encontrarTiendaMenorEspacio(Float espacio) throws ReadException;

    public List<Tienda> encontrarTiendaMayorEspacio(Float espacio) throws ReadException;

    public List<Tienda> encontrarTiendaEntreEspacio(Float espacioMin, Float espacioMax) throws ReadException;

    public List<Tienda> encontrarTiendaTipoPago(TipoPago tipoPago) throws ReadException;

}
