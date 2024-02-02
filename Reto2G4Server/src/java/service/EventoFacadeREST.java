/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Evento;
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
 * Clase que expone servicios RESTful para la entidad Evento. Permite realizar
 * operaciones CRUD (Create, Read, Update, Delete) sobre los datos de Evento.
 * Los métodos de esta clase gestionan las solicitudes HTTP y llaman a los
 * métodos correspondientes en la interfaz EJBTEventoInterface. La ruta base
 * para estos servicios es "entities.evento".
 *
 * @author Iñigo
 */
@Stateless
@Path("entities.evento")
public class EventoFacadeREST {

    @EJB
    private EJBEventoInterface ei;

    public EventoFacadeREST() {

    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Evento evento) throws CreateException {
        ei.createEvento(evento);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Evento evento) throws UpdateException {
        ei.editEvento(evento);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) throws ReadException, DeleteException {
        Evento evento = ei.encontrarEventoId(id);
        ei.deleteEvento(evento);
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Evento find(@PathParam("id") Integer id) throws ReadException {
        return ei.encontrarEventoId(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Evento> findAll() throws ReadException {
        return ei.findAll();
    }

    @GET
    @Path("encontrarEventoMayorNumParticipantes/{numParticipantes}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Evento> encontrarEventoMayorNumParticipantes(@PathParam("numParticipantes") int numParticipantes) throws ReadException {
        return ei.encontrarEventoMayorNumParticipantes(numParticipantes);
    }

    @GET
    @Path("encontrarEventoMenorNumParticipantes/{numParticipantes}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Evento> encontrarEventoMenorNumParticipantes(@PathParam("numParticipantes") int numParticipantes) throws ReadException {
        return ei.encontrarEventoMenorNumParticipantes(numParticipantes);
    }

    @GET
    @Path("encontrarEventoEntreParticipantes/{numParticipantesMin}/{numParticipantesMax}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Evento> encontrarEventoEntreParticipantes(@PathParam("numParticipantesMin") int numParticipantesMin, @PathParam("numParticipantesMax") int numParticipantesMax) throws ReadException {
        return ei.encontrarEventoEntreParticipantes(numParticipantesMin, numParticipantesMax);
    }

    @GET
    @Path("encontrarEventoMayorRecaudado/{totalRecaudado}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Evento> encontrarEventoMayorRecaudado(@PathParam("totalRecaudado") double totalRecaudado) throws ReadException {
        return ei.encontrarEventoMayorRecaudado(totalRecaudado);
    }

    @GET
    @Path("encontrarEventoMenorRecaudado/{totalRecaudado}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Evento> encontrarEventoMenorRecaudado(@PathParam("totalRecaudado") double totalRecaudado) throws ReadException {
        return ei.encontrarEventoMenorRecaudado(totalRecaudado);
    }

    @GET
    @Path("encontrarEventoEntreRecaudado/{totalRecaudadoMin}/{totalRecaudadoMax}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Evento> encontrarEventoEntreRecaudado(@PathParam("totalRecaudadoMin") int totalRecaudadoMin, @PathParam("totalRecaudadoMax") int totalRecaudadoMax) throws ReadException {
        return ei.encontrarEventoEntreRecaudado(totalRecaudadoMin, totalRecaudadoMax);
    }
}
