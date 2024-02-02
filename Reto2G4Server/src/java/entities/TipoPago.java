/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * Enumeración que representa los posibles tipos de pago disponibles en
 * MarketMaker. Los valores posibles son: Efectivo, Tarjeta, EfectivoYTarjeta.
 *
 * Cada tipo de pago define la forma en que se puede realizar el pago en una
 * tienda.
 *
 * @author David
 */
public enum TipoPago {
    Efectivo, Tarjeta, EfectivoYTarjeta
}
