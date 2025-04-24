package Service;

import Repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    public List<Map<String, Object>> obtenerJugadoresPorEquipo(Integer idEquipo) {
        List<Object[]> datos = jugadorRepository.findJugadoresPorEquipoRaw(idEquipo);
        List<Map<String, Object>> lista = new ArrayList<>();

        for (Object[] fila : datos) {
            Map<String, Object> map = new HashMap<>();
            map.put("id_jugador", fila[0]);
            map.put("nombre", fila[1]);
            map.put("posicion", fila[2]);
            map.put("dorsal", fila[3]);
            lista.add(map);
        }

        return lista;
    }

    public List<Map<String, Object>> obtenerJugadoresConMasGoles(Integer minGoles) {
        List<Object[]> datos = jugadorRepository.findJugadoresConMasGolesRaw(minGoles);
        List<Map<String, Object>> lista = new ArrayList<>();

        for (Object[] fila : datos) {
            Map<String, Object> map = new HashMap<>();
            map.put("id_jugador", fila[0]);
            map.put("nombre", fila[1]);
            map.put("goles", fila[2]);
            lista.add(map);
        }

        return lista;
    }

}