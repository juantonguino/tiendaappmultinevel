package co.edu.usbcali.tiendaapp.service.impl;

import co.edu.usbcali.tiendaapp.domain.Pedido;
import co.edu.usbcali.tiendaapp.dto.PedidoDTO;
import co.edu.usbcali.tiendaapp.exceptions.ClienteException;
import co.edu.usbcali.tiendaapp.exceptions.EstadoPedidoException;
import co.edu.usbcali.tiendaapp.exceptions.PedidoException;
import co.edu.usbcali.tiendaapp.exceptions.messages.PedidoServiceMessage;
import co.edu.usbcali.tiendaapp.mapper.PedidoMapper;
import co.edu.usbcali.tiendaapp.repository.PedidoRepository;
import co.edu.usbcali.tiendaapp.service.ClienteService;
import co.edu.usbcali.tiendaapp.service.EstadoPedidoService;
import co.edu.usbcali.tiendaapp.service.PedidoService;
import co.edu.usbcali.tiendaapp.utils.ValidationUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    private final PedidoMapper pedidoMapper;

    private final ClienteService clienteService;

    private final EstadoPedidoService estadoPedidoService;


    @Override
    public List<PedidoDTO> obtenerTodos() {
        return pedidoMapper.domainToDtoList(pedidoRepository.findAll());
    }

    @Override
    public PedidoDTO buscarPorId(Integer id) throws PedidoException {
        ValidationUtility.integerIsNullOrLessZero(id, new PedidoException(PedidoServiceMessage.ID_NO_VALIDO_MSG));

        return pedidoRepository
                .findById(id)
                .map(pedidoMapper::domainToDto)
                .orElseThrow(() -> new PedidoException(String
                        .format(PedidoServiceMessage.PEDIDO_NO_ENCONTRADA_POR_ID, id)));
    }

    @Override
    public Pedido buscarPedidoPorId(Integer id) throws PedidoException {
        ValidationUtility.integerIsNullOrLessZero(id, new PedidoException(PedidoServiceMessage.ID_NO_VALIDO_MSG));

        return pedidoRepository
                .findById(id)
                .orElseThrow(() -> new PedidoException(String
                        .format(PedidoServiceMessage.PEDIDO_NO_ENCONTRADA_POR_ID, id)));
    }

    @Override
    public PedidoDTO guardar(PedidoDTO pedidoDTO) throws ClienteException, EstadoPedidoException, PedidoException {
        validarPedido(pedidoDTO, false);

        Pedido pedido = pedidoMapper.dtoToDomain(pedidoDTO);
        pedido.setCliente(clienteService.buscarClientePorId(pedidoDTO.getClienteId()));
        pedido.setEstadoPedido(estadoPedidoService.buscarEstadoPedidoPorId(pedidoDTO.getEstadoPedidoId()));

        return pedidoMapper.domainToDto(pedidoRepository.save(pedido));
    }

    @Override
    public PedidoDTO actualizar(PedidoDTO pedidoDTO) throws ClienteException, EstadoPedidoException, PedidoException {
        validarPedido(pedidoDTO, true);

        Pedido pedido = pedidoMapper.dtoToDomain(pedidoDTO);
        pedido.setCliente(clienteService.buscarClientePorId(pedidoDTO.getClienteId()));
        pedido.setEstadoPedido(estadoPedidoService.buscarEstadoPedidoPorId(pedidoDTO.getEstadoPedidoId()));

        return pedidoMapper.domainToDto(pedidoRepository.save(pedido));
    }

    private void validarPedido(PedidoDTO pedidoDTO, Boolean esActualizar) throws PedidoException {
        if (Boolean.TRUE.equals(esActualizar)){
            ValidationUtility.isNull(pedidoDTO.getId(),
                    new PedidoException(PedidoServiceMessage.ID_REQUERIDO));
        }

        ValidationUtility.isNull(pedidoDTO,
                new PedidoException(PedidoServiceMessage.PEDIDO_NULO));
        ValidationUtility.isNull(pedidoDTO.getFecha(),
                new PedidoException(PedidoServiceMessage.FECHA_REQUERIDA));
        ValidationUtility.bigDecimalIsNullOrLessZero(pedidoDTO.getTotal(),
                new PedidoException(PedidoServiceMessage.TOTAL_REQUERIDO));
        ValidationUtility.integerIsNullOrLessZero(pedidoDTO.getClienteId(),
                new PedidoException(PedidoServiceMessage.CLIENTE_ID_REQUERIDO));
        ValidationUtility.integerIsNullOrLessZero(pedidoDTO.getEstadoPedidoId(),
                new PedidoException(PedidoServiceMessage.ESTADO_PEDIDO_ID_REQUERIDO));
    }
}