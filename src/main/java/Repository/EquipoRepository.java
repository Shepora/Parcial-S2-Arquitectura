package Repository;

import Model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {

    @Query(value = "SELECT id_equipo, nombre, ciudad, fundacion FROM equipo", nativeQuery = true)
    List<Object[]> findEquiposRaw();
}