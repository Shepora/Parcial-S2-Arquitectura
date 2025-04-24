package Controller;

import Model.Equipo;
import Repository.EquipoRepository;
import Service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @Autowired
    private EquipoRepository equipoRepository;

    @GetMapping
    public List<Equipo> listar() {
        return equipoRepository.findAll();
    }

    @PostMapping
    public Equipo crear(@RequestBody Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipo> actualizar(@PathVariable Integer id, @RequestBody Equipo equipo) {
        return equipoRepository.findById(id)
                .map(e -> {
                    e.setNombre(equipo.getNombre());
                    e.setCiudad(equipo.getCiudad());
                    e.setFundacion(equipo.getFundacion());
                    return ResponseEntity.ok(equipoRepository.save(e));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        equipoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
