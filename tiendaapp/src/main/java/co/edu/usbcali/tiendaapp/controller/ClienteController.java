package co.edu.usbcali.tiendaapp.controller;

import co.edu.usbcali.tiendaapp.dto.ClienteDTO;
import co.edu.usbcali.tiendaapp.exceptions.ClienteException;
import co.edu.usbcali.tiendaapp.exceptions.TipoDocumentoException;
import co.edu.usbcali.tiendaapp.request.CrearClienteRequest;
import co.edu.usbcali.tiendaapp.response.CrearClienteResponse;
import co.edu.usbcali.tiendaapp.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping("/")
    ResponseEntity<ClienteDTO> nuevoCliente(@RequestBody ClienteDTO clienteDTO) throws Exception {
        return ResponseEntity.ok(clienteService.guardar(clienteDTO));
    }

    @PostMapping("/nuevo")
    ResponseEntity<CrearClienteResponse> nuevoCliente(@RequestBody @Valid CrearClienteRequest crearClienteRequest) throws Exception {
        return ResponseEntity.ok(clienteService.crearCliente(crearClienteRequest));
    }

    @GetMapping("/{id}")
    ResponseEntity<ClienteDTO> buscarCliente(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @GetMapping("/")
    ResponseEntity<List<ClienteDTO>> obtenerCliente() throws Exception {
        return ResponseEntity.ok(clienteService.obtenerTodos());
    }

    @PutMapping("/")
    ResponseEntity<ClienteDTO> actualizar(@RequestBody @Valid ClienteDTO clienteDTO) throws TipoDocumentoException, ClienteException {
        return ResponseEntity.ok(clienteService.actualizar(clienteDTO));
    }

}
