package co.edu.usbcali.tiendaapp.service.impl;

import co.edu.usbcali.tiendaapp.domain.TipoDocumento;
import co.edu.usbcali.tiendaapp.dto.TipoDocumentoDTO;
import co.edu.usbcali.tiendaapp.exceptions.TipoDocumentoException;
import co.edu.usbcali.tiendaapp.exceptions.messages.TipoDocumentoServiceMessage;
import co.edu.usbcali.tiendaapp.mapper.TipoDocumentoMapper;
import co.edu.usbcali.tiendaapp.repository.TipoDocumentoRepository;
import co.edu.usbcali.tiendaapp.service.TipoDocumentoService;
import co.edu.usbcali.tiendaapp.utils.ValidationUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoDocumentoServiceImpl implements TipoDocumentoService {
    private final TipoDocumentoRepository tipoDocumentoRepository;

    private final TipoDocumentoMapper tipoDocumentoMapper;

    @Override
    public List<TipoDocumentoDTO> obtenerTodos() {
        return tipoDocumentoMapper.domainToDtoList(tipoDocumentoRepository.findAll());
    }

    @Override
    public TipoDocumentoDTO buscarPorId(Integer id) throws TipoDocumentoException {
        ValidationUtility.integerIsNullOrLessZero(id,
                new TipoDocumentoException(TipoDocumentoServiceMessage.ID_NO_VALIDO_MSG));

        return tipoDocumentoRepository
                .findById(id)
                .map(tipoDocumentoMapper::domainToDto)
                .orElseThrow(() -> new TipoDocumentoException(String
                        .format(TipoDocumentoServiceMessage.TIPO_DOCUMENTO_NO_ENCONTRADO_POR_ID, id))
                );
    }

    @Override
    public TipoDocumento buscarTipoDocumentoPorId(Integer id) throws TipoDocumentoException {
        ValidationUtility.integerIsNullOrLessZero(id,
                new TipoDocumentoException(TipoDocumentoServiceMessage.ID_NO_VALIDO_MSG));

        return tipoDocumentoRepository
                .findById(id)
                .orElseThrow(() -> new TipoDocumentoException(String
                        .format(TipoDocumentoServiceMessage.TIPO_DOCUMENTO_NO_ENCONTRADO_POR_ID, id))
                );
    }
}
