package co.edu.usbcali.tiendaapp.service.impl;

import co.edu.usbcali.tiendaapp.domain.EstadoPedido;
import co.edu.usbcali.tiendaapp.dto.EstadoPedidoDTO;
import co.edu.usbcali.tiendaapp.exceptions.EstadoPedidoException;
import co.edu.usbcali.tiendaapp.exceptions.messages.EstadoPedidoServiceMessage;
import co.edu.usbcali.tiendaapp.mapper.EstadoPedidoMapper;
import co.edu.usbcali.tiendaapp.repository.EstadoPedidoRepository;
import co.edu.usbcali.tiendaapp.service.EstadoPedidoService;
import co.edu.usbcali.tiendaapp.utils.ValidationUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstadoPedidoServiceImpl implements EstadoPedidoService {

    private final EstadoPedidoRepository estadoPedidoRepository;

    private final EstadoPedidoMapper estadoPedidoMapper;

    @Override
    public List<EstadoPedidoDTO> obtenerTodos() {
        return estadoPedidoMapper.domainToDtoList(estadoPedidoRepository.findAll());
    }

    @Override
    public EstadoPedidoDTO buscarPorId(Integer id) throws EstadoPedidoException {
        ValidationUtility.integerIsNullOrLessZero(id,
                new EstadoPedidoException(EstadoPedidoServiceMessage.ID_NO_VALIDO_MSG));

        return estadoPedidoRepository
                .findById(id)
                .map(estadoPedidoMapper::domainToDto)
                .orElseThrow(() -> new EstadoPedidoException(String
                        .format(EstadoPedidoServiceMessage.ESTADO_PEDIDO_NO_ENCONTRADA_POR_ID, id))
                );
    }

    @Override
    public EstadoPedido buscarEstadoPedidoPorId(Integer id) throws EstadoPedidoException {
        ValidationUtility.integerIsNullOrLessZero(id,
                new EstadoPedidoException(EstadoPedidoServiceMessage.ID_NO_VALIDO_MSG));

        return estadoPedidoRepository
                .findById(id)
                .orElseThrow(() -> new EstadoPedidoException(String
                        .format(EstadoPedidoServiceMessage.ESTADO_PEDIDO_NO_ENCONTRADA_POR_ID, id))
                );
    }
}
