/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.Tienda;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * Clase que representa a un cliente en MarketMakers. Hereda de la clase base
 * Usuario. Contiene información específica de los clientes, como el tipo de
 * venta y la tienda asociada.
 *
 * @author David
 */
@Entity
public class Cliente extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String tipoDeVenta;

    @OneToOne(cascade=ALL, fetch=FetchType.LAZY)
    @MapsId
    @JoinColumn(name="idUsuario")
    private Tienda tienda;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Producto> productosCreados;
    

    @XmlTransient
    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    @Override
    public String toString() {
        return super.toString()+"Cliente{" + "tipoDeVenta=" + tipoDeVenta + ", tienda=" + tienda + ", productosCreados=" + productosCreados + '}';
    }
    
    

}
