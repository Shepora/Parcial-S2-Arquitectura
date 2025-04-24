package Controller;

import Model.Entrenador;
import Repository.EntrenadorRepository;
import Service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    @GetMapping
    public List<Entrenador> getAllEntrenadores() {
        return entrenadorService.getAllEntrenadores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> getEntrenadorById(@PathVariable Integer id) {
        return entrenadorService.getEntrenadorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Entrenador createEntrenador(@RequestBody Entrenador entrenador) {
        return entrenadorService.saveEntrenador(entrenador);
    }

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @GetMapping
    public List<Entrenador> listar() {
        return entrenadorRepository.findAll();
    }

    @PostMapping
    public Entrenador crear(@RequestBody Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrenador> actualizar(@PathVariable Integer id, @RequestBody Entrenador entrenador) {
        return entrenadorRepository.findById(id)
                .map(e -> {
                    e.setNombre(entrenador.getNombre());
                    e.setEspecialidad(entrenador.getEspecialidad());
                    e.setEquipo(entrenador.getEquipo());
                    return ResponseEntity.ok(entrenadorRepository.save(e));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        entrenadorRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}