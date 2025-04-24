package Repository;

import Model.EstadisticaJugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadisticaJugadorRepository extends JpaRepository<EstadisticaJugador, Integer> {

    @Query(value = """
        SELECT j.id_equipo, SUM(e.goles) AS total_goles
        FROM estadistica_jugador e
        JOIN jugador j ON e.id_jugador = j.id_jugador
        WHERE j.id_equipo = :idEquipo
        GROUP BY j.id_equipo
        """, nativeQuery = true)
    List<Object[]> findTotalGolesPorEquipoRaw(@Param("idEquipo") Integer idEquipo);
}
