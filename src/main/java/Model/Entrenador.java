package Model;

import jakarta.persistence.*;

@Entity
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_entrenador;

    private String nombre;
    private String especialidad;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Equipo Equipo;

    public Entrenador(long id_entrenador, String nombre, String especialidad, Equipo equipo) {
        this.id_entrenador = id_entrenador;
        this.nombre = nombre;
        this.especialidad = especialidad;
        Equipo = equipo;
    }

    public long getId_entrenador() {
        return id_entrenador;
    }

    public void setId_entrenador(long id_entrenador) {
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
        return Equipo;
    }

    public void setEquipo(Equipo equipo) {
        Equipo = equipo;
    }
}
