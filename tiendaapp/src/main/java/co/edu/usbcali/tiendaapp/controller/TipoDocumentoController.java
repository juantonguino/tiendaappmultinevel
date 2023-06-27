package co.edu.usbcali.tiendaapp.controller;

import co.edu.usbcali.tiendaapp.domain.TipoDocumento;
import co.edu.usbcali.tiendaapp.dto.TipoDocumentoDTO;
import co.edu.usbcali.tiendaapp.exceptions.TipoDocumentoException;
import co.edu.usbcali.tiendaapp.repository.TipoDocumentoRepository;
import co.edu.usbcali.tiendaapp.service.TipoDocumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tipodocumento")
public class TipoDocumentoController {

    private final TipoDocumentoRepository tipoDocumentoRepository;

    private final TipoDocumentoService tipoDocumentoService;

    @GetMapping("/buscartodos")
    public ResponseEntity<List<TipoDocumentoDTO>> getAll(){
        return ResponseEntity.ok(tipoDocumentoService.obtenerTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<TipoDocumentoDTO> getById(@PathVariable Integer id) throws TipoDocumentoException {
        return ResponseEntity.ok(tipoDocumentoService.buscarPorId(id));
    }
}
