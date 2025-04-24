package Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_entrenador;

    private String nombre;
    private String especialidad;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    @JsonBackReference(value = "equipo-entrenadores")
    private Equipo equipo;

    public Entrenador() {
    }

    public Entrenador(Integer id_entrenador, String nombre, String especialidad, Equipo equipo) {
        this.id_entrenador = id_entrenador;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.equipo = equipo;
    }

    public Integer getId_entrenador() {
        return id_entrenador;
    }

    public void setId_entrenador(Integer id_entrenador) {
        this.id_entrenador = id_entrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}