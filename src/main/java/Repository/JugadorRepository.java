package Repository;

import Model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {

    @Query(value = "SELECT j.id_jugador, j.nombre, j.posicion, j.dorsal FROM jugador j WHERE j.id_equipo = :idEquipo", nativeQuery = true)
    List<Object[]> findJugadoresPorEquipoRaw(@Param("idEquipo") Integer idEquipo);

    @Query(value = """
    SELECT j.id_jugador, j.nombre, SUM(e.goles) AS total_goles
    FROM jugador j
    JOIN estadistica_jugador e ON j.id_jugador = e.id_jugador
    GROUP BY j.id_jugador, j.nombre
    HAVING SUM(e.goles) > :minGoles
    """, nativeQuery = true)
    List<Object[]> findJugadoresConMasGolesRaw(@Param("minGoles") Integer minGoles);
}
