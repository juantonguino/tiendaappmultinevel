package co.edu.usbcali.tiendaapp.service.impl;

import co.edu.usbcali.tiendaapp.domain.Cliente;
import co.edu.usbcali.tiendaapp.dto.ClienteDTO;
import co.edu.usbcali.tiendaapp.exceptions.ClienteException;
import co.edu.usbcali.tiendaapp.exceptions.TipoDocumentoException;
import co.edu.usbcali.tiendaapp.exceptions.messages.ClienteServiceMessage;
import co.edu.usbcali.tiendaapp.mapper.ClienteMapper;
import co.edu.usbcali.tiendaapp.repository.ClienteRepository;
import co.edu.usbcali.tiendaapp.request.CrearClienteRequest;
import co.edu.usbcali.tiendaapp.response.CrearClienteResponse;
import co.edu.usbcali.tiendaapp.service.ClienteService;
import co.edu.usbcali.tiendaapp.service.TipoDocumentoService;
import co.edu.usbcali.tiendaapp.utils.ValidationUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private static final Integer ESTADO_LENGTH = 1;

    private final ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper;

    private final TipoDocumentoService tipoDocumentoService;

    @Override
    public List<ClienteDTO> obtenerTodos() {
        return clienteMapper.domainToDtoList(clienteRepository.findAll());
    }

    @Override
    public ClienteDTO buscarPorId(Integer id) throws ClienteException {
        ValidationUtility.integerIsNullOrLessZero(id, new ClienteException(ClienteServiceMessage.ID_NO_VALIDO_MSG));

        return clienteRepository
                .findById(id)
                .map(clienteMapper::domainToDto)
                .orElseThrow(() -> new ClienteException(String
                        .format(ClienteServiceMessage.CLIENTE_NO_ENCONTRADO_POR_ID, id))
                );
    }

    @Override
    public Cliente buscarClientePorId(Integer id) throws ClienteException {
        ValidationUtility.integerIsNullOrLessZero(id, new ClienteException(ClienteServiceMessage.ID_NO_VALIDO_MSG));

        return clienteRepository
                .findById(id)
                .orElseThrow(() -> new ClienteException(String
                        .format(ClienteServiceMessage.CLIENTE_NO_ENCONTRADO_POR_ID, id))
                );
    }

    @Override
    public ClienteDTO guardar(ClienteDTO clienteDTO) throws ClienteException, TipoDocumentoException {
        validarCliente(clienteDTO, false);

        Cliente cliente = clienteMapper.dtoToDomain(clienteDTO);
        cliente.setTipoDocumento(tipoDocumentoService.buscarTipoDocumentoPorId(clienteDTO.getTipoDocumentoId()));

        return clienteMapper.domainToDto(clienteRepository.save(cliente));
    }

    @Override
    public ClienteDTO actualizar(ClienteDTO clienteDTO) throws ClienteException, TipoDocumentoException {
        validarCliente(clienteDTO, true);

        Cliente cliente = clienteMapper.dtoToDomain(clienteDTO);
        cliente.setTipoDocumento(tipoDocumentoService.buscarTipoDocumentoPorId(clienteDTO.getTipoDocumentoId()));

        return clienteMapper.domainToDto(clienteRepository.save(cliente));
    }

    @Override
    public CrearClienteResponse crearCliente(CrearClienteRequest crearClienteRequest) throws Exception {
        return null;
    }

    private void validarCliente(ClienteDTO clienteDTO, Boolean esActualizar) throws ClienteException {
        if (Boolean.TRUE.equals(esActualizar)){
            ValidationUtility.isNull(clienteDTO.getId(),
                    new ClienteException(ClienteServiceMessage.ID_REQUERIDO));
        }

        ValidationUtility.isNull(clienteDTO,
                new ClienteException(ClienteServiceMessage.CLIENTE_NULO));
        ValidationUtility.stringIsNullOrBlank(clienteDTO.getNombres(),
                new ClienteException(ClienteServiceMessage.NOMBRES_REQUERIDOS));
        ValidationUtility.stringIsNullOrBlank(clienteDTO.getApellidos(),
                new ClienteException(ClienteServiceMessage.APELLIDOS_REQUERIDOS));
        ValidationUtility.stringIsNullOrBlank(clienteDTO.getDocumento(),
                new ClienteException(ClienteServiceMessage.DOCUMENTO_REQUERIDO));
        ValidationUtility.stringIsNullOrBlank(clienteDTO.getEstado(),
                new ClienteException(ClienteServiceMessage.ESTADO_REQUERIDO));
        ValidationUtility.stringLength(clienteDTO.getEstado(), ESTADO_LENGTH,
                new ClienteException(String.format(ClienteServiceMessage.ESTADO_SUPERA_LONGITUD, ESTADO_LENGTH)));
        ValidationUtility.integerIsNullOrLessZero(clienteDTO.getTipoDocumentoId(),
                new ClienteException(ClienteServiceMessage.TIPO_DOCUMENTO_ID_REQUERIDO));
    }
}
