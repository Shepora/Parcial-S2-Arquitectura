package Controller;

import Model.Jugador;
import Repository.JugadorRepository;
import Service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping("/por-equipo/{id}")
    public ResponseEntity<List<Map<String, Object>>> jugadoresPorEquipo(@PathVariable Integer id) {
        return ResponseEntity.ok(jugadorService.obtenerJugadoresPorEquipo(id));
    }

    @GetMapping("/goleadores")
    public ResponseEntity<List<Map<String, Object>>> goleadores(@RequestParam Integer goles) {
        return ResponseEntity.ok(jugadorService.obtenerJugadoresConMasGoles(goles));
    }

    @Autowired
    private JugadorRepository jugadorRepository;

    @GetMapping
    public List<Jugador> listar() {
        return jugadorRepository.findAll();
    }

    @PostMapping
    public Jugador crear(@RequestBody Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jugador> actualizar(@PathVariable Integer id, @RequestBody Jugador jugador) {
        return jugadorRepository.findById(id)
                .map(j -> {
                    j.setNombre(jugador.getNombre());
                    j.setPosicion(jugador.getPosicion());
                    j.setDorsal(jugador.getDorsal());
                    j.setFecha_nac(jugador.getFecha_nac());
                    j.setNacionalidad(jugador.getNacionalidad());
                    j.setEquipo(jugador.getEquipo());
                    return ResponseEntity.ok(jugadorRepository.save(j));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        jugadorRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}