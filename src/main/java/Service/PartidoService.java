package Service;

import Repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    public List<Map<String, Object>> obtenerResultadosPartidos() {
        List<Object[]> datos = partidoRepository.findResultadosPartidosRaw();
        List<Map<String, Object>> lista = new ArrayList<>();

        for (Object[] fila : datos) {
            Map<String, Object> map = new HashMap<>();
            map.put("id_partido", fila[0]);
            map.put("equipo_local", fila[1]);
            map.put("equipo_visita", fila[2]);
            map.put("goles_local", fila[3]);
            map.put("goles_visita", fila[4]);
            lista.add(map);
        }

        return lista;
    }
}