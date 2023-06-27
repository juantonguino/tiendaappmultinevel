package co.edu.usbcali.tiendaapp.controller;

import co.edu.usbcali.tiendaapp.dto.CategoriaDTO;
import co.edu.usbcali.tiendaapp.exceptions.CategoriaException;
import co.edu.usbcali.tiendaapp.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping("/buscar/{id}")
    ResponseEntity<CategoriaDTO> obtenerCatergorias(@PathVariable("id") Integer id) throws CategoriaException {
        return ResponseEntity.ok(categoriaService.buscarPorId(id));
    }

    @GetMapping("/buscartodos")
    ResponseEntity<List<CategoriaDTO>> obtenerCatergorias(){
        return ResponseEntity.ok(categoriaService.obtenerTodos());
    }

    @PostMapping("/nueva")
    ResponseEntity<CategoriaDTO> nuevaCategoria(@RequestBody CategoriaDTO categoriaDTO) throws CategoriaException {
        return ResponseEntity.ok(categoriaService.guardar(categoriaDTO));
    }

    @PutMapping("/actualizar")
    ResponseEntity<CategoriaDTO> updateCategoria(@RequestBody CategoriaDTO categoriaDTO) throws CategoriaException {
        return ResponseEntity.ok(categoriaService.actualiar(categoriaDTO));
    }
}
