package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_partido;

    private Date fecha;
    private String estadio;

    private int equipo_local;
    private int equipo_visita;

    private int goles_local;
    private int goles_visita;
}
