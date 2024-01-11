/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Administrador;
import entities.Cliente;
import entities.TipoVenta;
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
public interface EJBUsuarioInterface {

    public void createUsuario(Usuario usuario) throws CreateException;

    public void createCliente(Cliente cliente) throws CreateException;

    public void createAdmin(Administrador admin) throws CreateException;

    public void editUsuario(Usuario usuario) throws UpdateException;

    public void editCliente(Cliente cliente) throws UpdateException;

    public void editAdmin(Administrador admin) throws UpdateException;

    public void deleteUsuario(Usuario usuario) throws DeleteException;

    public Usuario iniciarSesion(String correo, String password) throws ReadException;

    public Usuario encontrarUsuarioId(int id) throws ReadException;

    public Usuario encontrarClienteId(int id) throws ReadException;

    public Usuario encontrarAdminId(int id) throws ReadException;

    public List<Usuario> findAll() throws ReadException;

    public List<Cliente> encontrarTodosClientes() throws ReadException;

    public List<Administrador> encontrarTodosAdmins() throws ReadException;

    public List<Usuario> encontrarUsuarioPorNombre(String nombre) throws ReadException;

    public List<Usuario> encontrarUsuarioPorTipoVenta(TipoVenta tipoVenta) throws ReadException;

    public List<Usuario> encontrarUsuarioPorMinNumeroEventos(int numEventos) throws ReadException;

    public List<Usuario> encontrarUsuarioPorMaxNumeroEventos(int numEventos) throws ReadException;

}
