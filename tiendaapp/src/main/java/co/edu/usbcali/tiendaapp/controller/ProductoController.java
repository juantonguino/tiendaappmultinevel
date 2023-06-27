package co.edu.usbcali.tiendaapp.controller;

import co.edu.usbcali.tiendaapp.dto.ProductoDTO;
import co.edu.usbcali.tiendaapp.exceptions.CategoriaException;
import co.edu.usbcali.tiendaapp.exceptions.ProductoException;
import co.edu.usbcali.tiendaapp.request.CrearProductoRequest;
import co.edu.usbcali.tiendaapp.response.CrearProductoResponse;
import co.edu.usbcali.tiendaapp.service.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping("/nuevo")
    CrearProductoResponse nuevoProducto(@RequestBody @Valid CrearProductoRequest crearProductoRequest) throws Exception {
        return productoService.guardarNuevo(crearProductoRequest);
    }

    @PostMapping("/")
    ResponseEntity<ProductoDTO> crearProducto(@RequestBody @Valid ProductoDTO productoDTO) throws ProductoException, CategoriaException {
        return  ResponseEntity.ok(productoService.guardar(productoDTO));
    }

    @GetMapping("/{id}")
    ResponseEntity<ProductoDTO> bucarPorId(@PathVariable Integer id) throws ProductoException {
        return ResponseEntity.ok(productoService.buscarPorId(id));
    }

    @GetMapping("/")
    ResponseEntity<List<ProductoDTO>> obtenerTodos(){
        return ResponseEntity.ok(productoService.obtenerTodos());
    }

    @PutMapping("/")
    ResponseEntity<ProductoDTO> actualizarProducto(@RequestBody @Valid ProductoDTO productoDTO) throws ProductoException, CategoriaException {
        return  ResponseEntity.ok(productoService.actualizar(productoDTO));
    }
}
