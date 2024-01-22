/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gonzalo
 */
@Entity
@Table(name = "producto", schema = "marketMaker")
@NamedQueries({
    @NamedQuery(
            name = "encontrarProductoTodos", query = "SELECT p FROM Producto p"
    )
    ,

    @NamedQuery(
            name = "encontrarProductoTodosTienda", query = "SELECT p FROM Producto p WHERE p.tienda.idTienda=:idTienda"
    )
    ,

    @NamedQuery(
            name = "encontrarProductoNombre", query = "SELECT p FROM Producto p WHERE nombre=:nombre"
    )
    ,

    @NamedQuery(
            name = "encontrarProductoMenorAltura", query = "SELECT p FROM Producto p WHERE altura<=:altura and p.tienda.idTienda=:idTienda"
    )
    ,

    @NamedQuery(
            name = "encontrarProductoMayorAltura", query = "SELECT p FROM Producto p WHERE altura>=:altura and p.tienda.idTienda=:idTienda"
    )
    ,

    @NamedQuery(
            name = "encontrarProductoEntreAltura", query = "SELECT p FROM Producto p WHERE altura>:alturaMin and altura<:alturaMax and p.tienda.idTienda=:idTienda"
    )
    ,

    @NamedQuery(
            name = "encontrarProductoMenorPrecio", query = "SELECT p FROM Producto p WHERE precio<:precio and p.tienda.idTienda=:idTienda"
    )
    ,

    @NamedQuery(
            name = "encontrarProductoMayorPrecio", query = "SELECT p FROM Producto p WHERE precio>:precio and p.tienda.idTienda=:idTienda"
    )
    ,

    @NamedQuery(
            name = "encontrarProductoEntrePrecio", query = "SELECT p FROM Producto p WHERE precio>=:precioMin and precio<=:precioMax and p.tienda.idTienda=:idTienda"
    )
    ,

    @NamedQuery(
            name = "encontrarProductoMenorPeso", query = "SELECT p FROM Producto p WHERE peso<:peso and p.tienda.idTienda=:idTienda"
    )
    ,

    @NamedQuery(
            name = "encontrarProductoMayorPeso", query = "SELECT p FROM Producto p WHERE peso>:peso and p.tienda.idTienda=:idTienda"
    )
    ,
        @NamedQuery(
            name = "encontrarProductoEntrePeso", query = "SELECT p FROM Producto p WHERE peso>=:pesoMin and peso<=:pesoMax and p.tienda.idTienda=:idTienda"
    )
})
@XmlRootElement
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idProducto;
    private String nombre;
    private float precio;
    private int altura;
    private String material;
    private float peso;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechacreacion;

    @ManyToOne
    private Cliente cliente;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Tienda tienda;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @XmlTransient
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @XmlTransient
    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idProducto);
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
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.idProducto, other.idProducto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", precio=" + precio + ", talla=" + altura + ", material=" + material + ", peso=" + peso + ", fechacreacion=" + fechacreacion + ", cliente=" + cliente + ", tienda=" + tienda + '}';
    }

}
