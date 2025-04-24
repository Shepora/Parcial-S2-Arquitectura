package Service;

import Repository.EstadisticaJugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EstadisticaJugadorService {

    @Autowired
    private EstadisticaJugadorRepository estadisticaJugadorRepository;

    public List<Map<String, Object>> obtenerTotalGolesPorEquipo(Integer idEquipo) {
        List<Object[]> datos = estadisticaJugadorRepository.findTotalGolesPorEquipoRaw(idEquipo);
        List<Map<String, Object>> lista = new ArrayList<>();

        for (Object[] fila : datos) {
            Map<String, Object> map = new HashMap<>();
            map.put("id_equipo", fila[0]);
            map.put("total_goles", fila[1]);
            lista.add(map);
        }

        return lista;
    }
}