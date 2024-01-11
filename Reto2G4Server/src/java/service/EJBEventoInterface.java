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
import java.util.Date;
import java.util.List;

/**
 *
 * @author Iñigo
 */
public interface EJBEventoInterface {

    public void createEvento(Evento evento) throws CreateException;

    public void editEvento(Evento evento) throws UpdateException;

    public void deleteEvento(Evento evento) throws DeleteException;

    public List<Evento> findAll() throws ReadException;

    public Evento encontrarEventoId(int id) throws ReadException;

    public List<Evento> encontrarEventoMayorNumParticipantes(int numParticipantes) throws ReadException;

    public List<Evento> encontrarEventoMenorNumParticipantes(int numParticipantes) throws ReadException;

    public List<Evento> encontrarEventoEntreParticipantes(int numParticipantesMin, int numParticipantesMax) throws ReadException;

    public List<Evento> encontrarEventoMayorRecaudado(double totalRecaudado) throws ReadException;

    public List<Evento> encontrarEventoMenorRecaudado(double totalRecaudado) throws ReadException;

    public List<Evento> encontrarEventoEntreRecaudado(double totalRecaudadoMin, double totalRecaudado) throws ReadException;

}
