package Repository;

import Model.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntrenadorRepository extends JpaRepository<Entrenador, Integer> {

    @Query(value = "SELECT id_entrenador, nombre, especialidad, id_equipo FROM entrenador", nativeQuery = true)
    List<Object[]> findEntrenadoresRaw();
}
