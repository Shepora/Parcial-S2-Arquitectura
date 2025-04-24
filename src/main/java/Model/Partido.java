package Model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_partido;

    private Date fecha;
    private String estadio;
    private Integer goles_local;
    private Integer goles_visita;

    @ManyToOne
    @JoinColumn(name = "equipo_local")
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipo_visita")
    private Equipo equipoVisita;

    @OneToMany(mappedBy = "partido", cascade = CascadeType.ALL)
    private List<EstadisticaJugador> estadisticas;

    public Partido() {
    }

    public Partido(Integer id_partido, Date fecha, String estadio, Integer goles_local, Integer goles_visita, Equipo equipoLocal, Equipo equipoVisita, List<EstadisticaJugador> estadisticas) {
        this.id_partido = id_partido;
        this.fecha = fecha;
        this.estadio = estadio;
        this.goles_local = goles_local;
        this.goles_visita = goles_visita;
        this.equipoLocal = equipoLocal;
        this.equipoVisita = equipoVisita;
        this.estadisticas = estadisticas;
    }

    public Integer getId_partido() {
        return id_partido;
    }

    public void setId_partido(Integer id_partido) {
        this.id_partido = id_partido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public Integer getGoles_local() {
        return goles_local;
    }

    public void setGoles_local(Integer goles_local) {
        this.goles_local = goles_local;
    }

    public Integer getGoles_visita() {
        return goles_visita;
    }

    public void setGoles_visita(Integer goles_visita) {
        this.goles_visita = goles_visita;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisita() {
        return equipoVisita;
    }

    public void setEquipoVisita(Equipo equipoVisita) {
        this.equipoVisita = equipoVisita;
    }

    public List<EstadisticaJugador> getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(List<EstadisticaJugador> estadisticas) {
        this.estadisticas = estadisticas;
    }
}
