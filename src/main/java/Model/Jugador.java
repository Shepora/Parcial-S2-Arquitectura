package Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_jugador;

    private String nombre;
    private String posicion;
    private int dorsal;
    private Date fecha_nac;
    private String nacionalidad;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Equipo Equipo;

    public Jugador(long id_jugador, String nombre, String posicion, int dorsal, Date fecha_nac, String nacionalidad, Equipo equipo) {
        this.id_jugador = id_jugador;
        this.nombre = nombre;
        this.posicion = posicion;
        this.dorsal = dorsal;
        this.fecha_nac = fecha_nac;
        this.nacionalidad = nacionalidad;
        Equipo = equipo;
    }

    public long getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(long id_jugador) {
        this.id_jugador = id_jugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Equipo getEquipo() {
        return Equipo;
    }

    public void setEquipo(Equipo equipo) {
        Equipo = equipo;
    }
}
