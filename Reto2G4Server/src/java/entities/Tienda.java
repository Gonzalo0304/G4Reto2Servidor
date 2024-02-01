/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author David
 */
@Entity
@Table(name = "Tienda", schema = "marketMaker")
@NamedQueries({
    @NamedQuery(
            name = "encontrarTodasTiendas", query = "SELECT t FROM Tienda t"
    )
    ,

    @NamedQuery(
            name = "encontrarTiendaMenorEspacio", query = "SELECT t FROM Tienda t WHERE espacio<:espacio"
    )
    ,

    @NamedQuery(
            name = "encontrarTiendaMayorEspacio", query = "SELECT t FROM Tienda t WHERE espacio>:espacio"
    )
    ,

    @NamedQuery(
            name = "encontrarTiendaEntreEspacio", query = "SELECT t FROM Tienda t WHERE espacio>=:espacioMin and espacio<=:espacioMax"
    )
    ,

    @NamedQuery(
            name = "encontrarTiendaTipoPago", query = "SELECT t FROM Tienda t WHERE tipoPago=:tipoPago"
    )

})
@XmlRootElement
public class Tienda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTienda;
    private String nombre;
    private String descripcion;
    @Enumerated(EnumType.STRING)
    private TipoPago tipoPago;
    private float espacio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaCreacion;

    //@OneToOne(cascade = ALL)
    //@JoinColumn(name = "idCliente", referencedColumnName = "idUsuario")
    //private Cliente cliente;
    //@OneToOne(mappedBy = "tienda", cascade = CascadeType.PERSIST/*, cascade = CascadeType.ALL*/)
//    @OneToOne
//    @JoinColumn(name = "idUsuario")
    @OneToOne(mappedBy = "tienda")
    private Cliente cliente;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tienda")
    private List<Producto> productos;

    @OneToMany(mappedBy = "tienda")
    private List<TiendaEvento> listaTiendasEvento;

    public Integer getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(Integer idTienda) {
        this.idTienda = idTienda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public float getEspacio() {
        return espacio;
    }

    public void setEspacio(float espacio) {
        this.espacio = espacio;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @XmlTransient
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @XmlTransient
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @XmlTransient
    public List<TiendaEvento> getListaTiendasEvento() {
        return listaTiendasEvento;
    }

    public void setListaTiendasEvento(List<TiendaEvento> listaTiendasEvento) {
        this.listaTiendasEvento = listaTiendasEvento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idTienda;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tienda other = (Tienda) obj;
        if (this.idTienda != other.idTienda) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tienda{" + "idTienda=" + idTienda + ", nombre=" + nombre + ", descripcion=" + descripcion + ", tipoPago=" + tipoPago + ", espacio=" + espacio + ", fechaCreacion=" + fechaCreacion + ", productos=" + productos + '}';
    }

}
