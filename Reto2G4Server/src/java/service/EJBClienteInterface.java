/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Cliente;
import entities.Tienda;
import entities.Usuario;
import exceptions.CreateException;
import exceptions.DeleteException;
import exceptions.ReadException;
import exceptions.UpdateException;
import java.util.List;

/**
 *
 * @author David
 */
public interface EJBClienteInterface {

    public void createCliente(Cliente cliente) throws CreateException;

    public void editCliente(Cliente cliente) throws UpdateException;

    public void deleteCliente(Cliente cliente) throws DeleteException;

    public List<Cliente> findAll() throws ReadException;

    public List<Cliente> encontrarClienteMenorFechaNac() throws ReadException;

    public List<Cliente> encontrarClienteMayorFechaNac() throws ReadException;

    public List<Cliente> encontrarClienteEntreFechaNac() throws ReadException;

    public List<Cliente> encontrarClienteMayorNumEventos() throws ReadException;

    public List<Cliente> encontrarClienteMenorNumEventos() throws ReadException;

    public List<Cliente> encontrarClienteEntreNumEventos() throws ReadException;

    public List<Cliente> encontrarClienteSegunTipoVenta() throws ReadException;

}
