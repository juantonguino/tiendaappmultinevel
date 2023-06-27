package co.edu.usbcali.tiendaapp.controller;

import co.edu.usbcali.tiendaapp.dto.EstadoPedidoDTO;
import co.edu.usbcali.tiendaapp.exceptions.EstadoPedidoException;
import co.edu.usbcali.tiendaapp.service.EstadoPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estadopedido")
@CrossOrigin("*")
public class EstadoPedidoController {

    private final EstadoPedidoService estadoPedidoService;

    @GetMapping("/buscartodos")
    public ResponseEntity<List<EstadoPedidoDTO>> obtenerTodos(){
        return ResponseEntity.ok(estadoPedidoService.obtenerTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<EstadoPedidoDTO> buscarEstadoPedidoPorId(@PathVariable("id") Integer id) throws EstadoPedidoException {
        return  ResponseEntity.ok(estadoPedidoService.buscarPorId(id));
    }
}
