package Service;

import Model.Entrenador;
import Repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    public List<Entrenador> getAllEntrenadores() {
        return entrenadorRepository.findAll();
    }

    public Optional<Entrenador> getEntrenadorById(Integer id) {
        return entrenadorRepository.findById(id);
    }

    public Entrenador saveEntrenador(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public void deleteEntrenador(Integer id) {
        entrenadorRepository.deleteById(id);
    }

    public List<Map<String, Object>> obtenerEntrenadores() {
        List<Object[]> datos = entrenadorRepository.findEntrenadoresRaw();
        List<Map<String, Object>> lista = new ArrayList<>();

        for (Object[] fila : datos) {
            Map<String, Object> map = new HashMap<>();
            map.put("id_entrenador", fila[0]);
            map.put("nombre", fila[1]);
            map.put("especialidad", fila[2]);
            map.put("id_equipo", fila[3]);
            lista.add(map);
        }

        return lista;
    }
}