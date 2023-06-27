package co.edu.usbcali.tiendaapp.service;

import co.edu.usbcali.tiendaapp.domain.TipoDocumento;
import co.edu.usbcali.tiendaapp.dto.TipoDocumentoDTO;
import co.edu.usbcali.tiendaapp.exceptions.TipoDocumentoException;

import java.util.List;

public interface TipoDocumentoService {
    List<TipoDocumentoDTO> obtenerTodos();

    TipoDocumentoDTO buscarPorId(Integer id) throws TipoDocumentoException;

    TipoDocumento buscarTipoDocumentoPorId(Integer id) throws TipoDocumentoException;
}
