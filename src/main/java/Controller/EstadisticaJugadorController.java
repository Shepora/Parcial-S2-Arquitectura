package Controller;

import Model.EstadisticaJugador;
import Repository.EstadisticaJugadorRepository;
import Service.EstadisticaJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/estadisticas")
public class EstadisticaJugadorController {

    @Autowired
    private EstadisticaJugadorService estadisticaJugadorService;

    @GetMapping("/goles-equipo/{idEquipo}")
    public ResponseEntity<List<Map<String, Object>>> totalGolesEquipo(@PathVariable Integer idEquipo) {
        return ResponseEntity.ok(estadisticaJugadorService.obtenerTotalGolesPorEquipo(idEquipo));
    }

    @Autowired
    private EstadisticaJugadorRepository estadisticaJugadorRepository;

    @GetMapping
    public List<EstadisticaJugador> listar() {
        return estadisticaJugadorRepository.findAll();
    }

    @PostMapping
    public EstadisticaJugador crear(@RequestBody EstadisticaJugador estadistica) {
        return estadisticaJugadorRepository.save(estadistica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadisticaJugador> actualizar(@PathVariable Integer id, @RequestBody EstadisticaJugador estadistica) {
        return estadisticaJugadorRepository.findById(id)
                .map(e -> {
                    e.setMinutos_jugados(estadistica.getMinutos_jugados());
                    e.setGoles(estadistica.getGoles());
                    e.setAsistencias(estadistica.getAsistencias());
                    e.setTarjetas_amarillas(estadistica.getTarjetas_amarillas());
                    e.setTarjetas_rojas(estadistica.getTarjetas_rojas());
                    e.setJugador(estadistica.getJugador());
                    e.setPartido(estadistica.getPartido());
                    return ResponseEntity.ok(estadisticaJugadorRepository.save(e));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        estadisticaJugadorRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}