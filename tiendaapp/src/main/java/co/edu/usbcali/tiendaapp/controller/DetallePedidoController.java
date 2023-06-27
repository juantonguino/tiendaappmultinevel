package co.edu.usbcali.tiendaapp.controller;

import co.edu.usbcali.tiendaapp.dto.DetallePedidoDTO;
import co.edu.usbcali.tiendaapp.exceptions.ClienteException;
import co.edu.usbcali.tiendaapp.exceptions.TipoDocumentoException;
import co.edu.usbcali.tiendaapp.request.CrearClienteRequest;
import co.edu.usbcali.tiendaapp.response.CrearClienteResponse;
import co.edu.usbcali.tiendaapp.service.DetallePedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/detallepedido")
@CrossOrigin("*")
public class DetallePedidoController {

    private final DetallePedidoService detallePedidoService;


    @PostMapping("/")
    ResponseEntity<DetallePedidoDTO> nuevoCliente(@RequestBody DetallePedidoDTO detallePedidoDTO) throws Exception {
        return ResponseEntity.ok(detallePedidoService.guardar(detallePedidoDTO));
    }

    @GetMapping("/{id}")
    ResponseEntity<DetallePedidoDTO> buscarCliente(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(detallePedidoService.buscarPorId(id));
    }

    @GetMapping("/")
    ResponseEntity<List<DetallePedidoDTO>> obtenerCliente() throws Exception {
        return ResponseEntity.ok(detallePedidoService.obtenerTodos());
    }

    @PutMapping("/")
    ResponseEntity<DetallePedidoDTO> actualizar(@RequestBody @Valid DetallePedidoDTO detallePedidoDTO) throws Exception {
        return ResponseEntity.ok(detallePedidoService.actualizar(detallePedidoDTO));
    }
}
