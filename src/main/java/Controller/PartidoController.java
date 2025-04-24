package Controller;

import Model.Partido;
import Repository.PartidoRepository;
import Service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @GetMapping("/resultados")
    public ResponseEntity<List<Map<String, Object>>> resultadosPartidos() {
        return ResponseEntity.ok(partidoService.obtenerResultadosPartidos());
    }

    @Autowired
    private PartidoRepository partidoRepository;

    @GetMapping
    public List<Partido> listar() {
        return partidoRepository.findAll();
    }

    @PostMapping
    public Partido crear(@RequestBody Partido partido) {
        return partidoRepository.save(partido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partido> actualizar(@PathVariable Integer id, @RequestBody Partido partido) {
        return partidoRepository.findById(id)
                .map(p -> {
                    p.setFecha(partido.getFecha());
                    p.setEstadio(partido.getEstadio());
                    p.setGoles_local(partido.getGoles_local());
                    p.setGoles_visita(partido.getGoles_visita());
                    p.setEquipoLocal(partido.getEquipoLocal());
                    p.setEquipoVisita(partido.getEquipoVisita());
                    return ResponseEntity.ok(partidoRepository.save(p));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        partidoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
