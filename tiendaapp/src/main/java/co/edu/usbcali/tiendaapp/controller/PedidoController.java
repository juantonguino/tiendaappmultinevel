package co.edu.usbcali.tiendaapp.controller;

import co.edu.usbcali.tiendaapp.dto.PedidoDTO;
import co.edu.usbcali.tiendaapp.exceptions.ClienteException;
import co.edu.usbcali.tiendaapp.exceptions.EstadoPedidoException;
import co.edu.usbcali.tiendaapp.exceptions.PedidoException;
import co.edu.usbcali.tiendaapp.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pedido")
@CrossOrigin("*")
public class PedidoController {

    private final PedidoService pedidoService;
    @PostMapping("/")
    ResponseEntity<PedidoDTO> nuevoCliente(@RequestBody PedidoDTO pedidoDTO) throws Exception {
        return ResponseEntity.ok(pedidoService.guardar(pedidoDTO));
    }

    @GetMapping("/{id}")
    ResponseEntity<PedidoDTO> buscarCliente(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(pedidoService.buscarPorId(id));
    }

    @GetMapping("/")
    ResponseEntity<List<PedidoDTO>> obtenerCliente() throws Exception {
        return ResponseEntity.ok(pedidoService.obtenerTodos());
    }

    @PutMapping("/")
    ResponseEntity<PedidoDTO> actualizar(@RequestBody @Valid PedidoDTO pedidoDTO) throws PedidoException, EstadoPedidoException, ClienteException {
        return ResponseEntity.ok(pedidoService.actualizar(pedidoDTO));
    }
}
