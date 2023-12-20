/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Clase base para representar a todos los usuarios de MarketMaker, ya sean
 * clientes o administradores. Las clases Cliente y Administrador heredan de
 * esta clase. Contiene atributos genéricos comunes.
 *
 * @author Iñigo
 */
@Entity
@Table(name = "Usuario", schema = "marketMaker")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "TIPO_USUARIO", discriminatorType = DiscriminatorType.STRING)
@NamedQueries({
    
    @NamedQuery(
            name="encontrarUsuarioMenorFechaNac", query="SELECT e FROM Usuario e WHERE fechaNacimiento<:fechaNacimiento"
    ),
    
    @NamedQuery(
            name="encontrarUsuarioMayorFechaNac", query="SELECT e FROM Usuario e WHERE fechaNacimiento>:fechaNacimiento"
    ),
    
    @NamedQuery(
            name="encontrarUsuarioMayorNumEventos", query="SELECT e FROM Usuario e WHERE numEventos>:numEventos"
    ),
    
    @NamedQuery(
            name="encontrarUsuarioMenorNumEventos", query="SELECT e FROM Usuario e WHERE numEventos<:numEventos"
    ),
    
    @NamedQuery(
            name="encontrarUsuarioSegunTipoVenta", query="SELECT e FROM Evento e WHERE tipoVenta=:tipoVenta"
    ),
    
    
})
@XmlRootElement
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUsuario;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String correo;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNacimiento;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.idUsuario;
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
        final Usuario other = (Usuario) obj;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", password=" + password + ", correo=" + correo + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

   

}
