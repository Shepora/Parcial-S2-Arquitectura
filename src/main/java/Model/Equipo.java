package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_equipo;

    private String nombre;
    private String ciudad;
    private Date fundacion;

    public Equipo(long id_equipo, String nombre, String ciudad, Date fundacion) {
        this.id_equipo = id_equipo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.fundacion = fundacion;
    }

    public long getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(long id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Date getFundacion() {
        return fundacion;
    }

    public void setFundacion(Date fundacion) {
        this.fundacion = fundacion;
    }
}
