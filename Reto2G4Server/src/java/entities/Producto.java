/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gonzalo
 */

@Entity
@Table(name = "producto", schema = "marketMaker")
@NamedQueries({
    
    @NamedQuery(
            name="encontrarProductoMenorAltura", query="SELECT p FROM Producto p WHERE altura<:altura"
    ),
    
    @NamedQuery(
            name="encontrarProductoMayorAltura", query="SELECT p FROM Producto p WHERE altura>:altura"
    ),
    
    @NamedQuery(
            name="encontrarProductoEntreAltura", query="SELECT p FROM Producto p WHERE altura<=:alturaMin and altura>=:alturaMax"
    ),
    
    @NamedQuery(
            name="encontrarProductoMenorPrecio", query="SELECT p FROM Producto p WHERE precio<:precio"
    ),
    
    @NamedQuery(
            name="encontrarProductoMayorPrecio", query="SELECT p FROM Producto p WHERE precio>:precio"
    ),
    
    @NamedQuery(
            name="encontrarProductoEntrePrecio", query="SELECT p FROM Producto p WHERE precio<=:precioMin and precio>=:precioMax"
    ),
    
    @NamedQuery(
            name="encontrarProductoMenorPeso", query="SELECT p FROM Producto p WHERE peso<:peso"
    ),
    
    @NamedQuery(
            name="encontrarProductoMayorPeso", query="SELECT p FROM Producto p WHERE peso>:peso"
    ),
        @NamedQuery(
            name="encontrarProductoEntrePeso", query="SELECT p FROM Producto p WHERE peso<=:pesoMin and peso>=:pesoMax"
    )
})
@XmlRootElement
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idProducto;
    private double precio;
    private String altura;
    private String material;
    private double peso;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechacreacion;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Tienda tienda;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTalla() {
        return altura;
    }

    public void setTalla(String talla) {
        this.altura = talla;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
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
