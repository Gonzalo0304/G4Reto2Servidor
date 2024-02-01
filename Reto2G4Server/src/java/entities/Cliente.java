/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
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
@DiscriminatorValue("Cliente")
@XmlRootElement
public class Cliente extends Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    private TipoVenta tipoVenta;

    //@OneToOne(cascade = ALL, orphanRemoval = true)
//    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_tienda")
//    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, optional = true)
    @JoinColumn(name = "id_tienda", referencedColumnName = "idTienda")
    private Tienda tienda;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Producto> productosCreados;

    public TipoVenta getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(TipoVenta tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    @XmlTransient
    public List<Producto> getProductosCreados() {
        return productosCreados;
    }

    public void setProductosCreados(List<Producto> productosCreados) {
        this.productosCreados = productosCreados;
    }

    @Override
    public String toString() {
        return super.toString() + "Cliente{" + "tipoVenta=" + tipoVenta + ", tienda=" + tienda + ", productosCreados=" + productosCreados + '}';
    }

}
