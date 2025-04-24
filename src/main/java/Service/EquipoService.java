package Service;

import Repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    public List<Map<String, Object>> obtenerEquipos() {
        List<Object[]> datos = equipoRepository.findEquiposRaw();
        List<Map<String, Object>> lista = new ArrayList<>();

        for (Object[] fila : datos) {
            Map<String, Object> map = new HashMap<>();
            map.put("id_equipo", fila[0]);
            map.put("nombre", fila[1]);
            map.put("ciudad", fila[2]);
            map.put("fundacion", fila[3]);
            lista.add(map);
        }

        return lista;
    }
}