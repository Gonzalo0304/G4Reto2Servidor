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
import java.time.Clock;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Iñigo
 */
@Stateless
public class EJBEvento implements EJBEventoInterface {

    @PersistenceContext(unitName = "Reto2G4ServerPU")
    private EntityManager em;

    @Override
    public void createEvento(Evento evento) throws CreateException {
        try {
            em.persist(evento);
        } catch (Exception e) {
            throw new CreateException(e.getMessage());
        }
    }

    @Override
    public void editEvento(Evento evento) throws UpdateException {
        try {
            if (!em.contains(evento)) {
                em.merge(evento);
            }
            em.flush();
        } catch (Exception e) {
            throw new UpdateException(e.getMessage());
        }
    }

    @Override
    public void deleteEvento(Evento evento) throws DeleteException {
        try {
            em.remove(evento);
        } catch (Exception e) {
            throw new DeleteException(e.getMessage());
        }
    }

    @Override
    public Evento encontrarEventoId(int id) throws ReadException {
        Evento evento;
        try {
            evento = em.find(Evento.class, id);
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return evento;
    }

    @Override
    public List<Evento> findAll() throws ReadException {
        List<Evento> eventos;
        try {
            eventos = em.createNamedQuery("encontrarTodosEventos").getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return eventos;
    }

    @Override
    public List<Evento> encontrarEventoMayorNumParticipantes(int numParticipantes) throws ReadException {
        List<Evento> eventos;
        try {
            eventos = em.createNamedQuery("encontrarEventoMayorNumParticipantes").setParameter("numParticipantes", numParticipantes).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return eventos;
    }

    @Override
    public List<Evento> encontrarEventoMenorNumParticipantes(int numParticipantes) throws ReadException {
        List<Evento> eventos;
        try {
            eventos = em.createNamedQuery("encontrarEventoMenorNumParticipantes").setParameter("numParticipantes", numParticipantes).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return eventos;
    }

    @Override
    public List<Evento> encontrarEventoEntreParticipantes(int numParticipantesMin, int numParticipantesMax) throws ReadException {
        List<Evento> eventos;
        try {
            eventos = em.createNamedQuery("encontrarEventoEntreParticipantes").setParameter("numParticipantesMin", numParticipantesMin).setParameter("numParticipantesMax", numParticipantesMax).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return eventos;
    }

    @Override
    public List<Evento> encontrarEventoMayorRecaudado(double totalRecaudado) throws ReadException {
        List<Evento> eventos;
        try {
            eventos = em.createNamedQuery("encontrarEventoMayorRecaudado").setParameter("totalRecaudado", totalRecaudado).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return eventos;
    }

    @Override
    public List<Evento> encontrarEventoMenorRecaudado(double totalRecaudado) throws ReadException {
        List<Evento> eventos;
        try {
            eventos = em.createNamedQuery("encontrarEventoMenorRecaudado").setParameter("totalRecaudado", totalRecaudado).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return eventos;
    }

    @Override
    public List<Evento> encontrarEventoEntreRecaudado(double totalRecaudadoMin, double totalRecaudadoMax) throws ReadException {
        List<Evento> eventos;
        try {
            eventos = em.createNamedQuery("encontrarEventoEntreRecaudado").setParameter("totalRecaudadoMin", totalRecaudadoMin).setParameter("totalRecaudadoMax", totalRecaudadoMax).getResultList();
        } catch (Exception e) {
            throw new ReadException(e.getMessage());
        }
        return eventos;
    }

}
