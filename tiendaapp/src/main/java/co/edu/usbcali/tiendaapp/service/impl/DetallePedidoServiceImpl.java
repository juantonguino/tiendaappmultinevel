package co.edu.usbcali.tiendaapp.service.impl;


import co.edu.usbcali.tiendaapp.domain.DetallePedido;
import co.edu.usbcali.tiendaapp.dto.DetallePedidoDTO;
import co.edu.usbcali.tiendaapp.exceptions.DetallePedidoException;
import co.edu.usbcali.tiendaapp.exceptions.PedidoException;
import co.edu.usbcali.tiendaapp.exceptions.ProductoException;
import co.edu.usbcali.tiendaapp.exceptions.messages.DetallePedidoServiceMessage;
import co.edu.usbcali.tiendaapp.mapper.DetallePedidoMapper;
import co.edu.usbcali.tiendaapp.repository.DetallePedidoRepository;
import co.edu.usbcali.tiendaapp.service.DetallePedidoService;
import co.edu.usbcali.tiendaapp.service.PedidoService;
import co.edu.usbcali.tiendaapp.service.ProductoService;
import co.edu.usbcali.tiendaapp.utils.ValidationUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetallePedidoServiceImpl implements DetallePedidoService {

    private final DetallePedidoRepository detallePedidoRepository;

    private final DetallePedidoMapper detallePedidoMapper;

    private final PedidoService pedidoService;

    private final ProductoService productoService;

    @Override
    public List<DetallePedidoDTO> obtenerTodos() {
        return detallePedidoMapper.domainToDtoList(detallePedidoRepository.findAll());
    }

    @Override
    public DetallePedidoDTO buscarPorId(Integer id) throws DetallePedidoException {
        ValidationUtility.integerIsNullOrLessZero(id,
                new DetallePedidoException(DetallePedidoServiceMessage.ID_NO_VALIDO_MSG));

        return detallePedidoRepository
                .findById(id)
                .map(detallePedidoMapper::domainToDto)
                .orElseThrow(() -> new DetallePedidoException(String
                        .format(DetallePedidoServiceMessage.DETALLE_PEDIDO_NO_ENCONTRADA_POR_ID, id))
                );
    }

    @Override
    public DetallePedidoDTO guardar(DetallePedidoDTO detallePedidoDTO)
            throws PedidoException, ProductoException, DetallePedidoException {
        validarDetallePedido(detallePedidoDTO, false);

        DetallePedido detallePedido = detallePedidoMapper.dtoToDomain(detallePedidoDTO);
        detallePedido.setPedido(pedidoService.buscarPedidoPorId(detallePedidoDTO.getPedidoId()));
        detallePedido.setProducto(productoService.buscarProductoPorId(detallePedidoDTO.getProductoId()));

        return detallePedidoMapper.domainToDto(detallePedidoRepository.save(detallePedido));
    }

    @Override
    public DetallePedidoDTO actualizar(DetallePedidoDTO detallePedidoDTO)
            throws PedidoException, ProductoException, DetallePedidoException {
        validarDetallePedido(detallePedidoDTO, true);

        DetallePedido detallePedido = detallePedidoMapper.dtoToDomain(detallePedidoDTO);
        detallePedido.setPedido(pedidoService.buscarPedidoPorId(detallePedidoDTO.getPedidoId()));
        detallePedido.setProducto(productoService.buscarProductoPorId(detallePedidoDTO.getProductoId()));

        return detallePedidoMapper.domainToDto(detallePedidoRepository.save(detallePedido));
    }

    private void validarDetallePedido(DetallePedidoDTO detallePedidoDTO, Boolean esActualizar)
            throws DetallePedidoException {
        if (Boolean.TRUE.equals(esActualizar)){
            ValidationUtility.isNull(detallePedidoDTO.getId(),
                    new DetallePedidoException(DetallePedidoServiceMessage.ID_REQUERIDO));
        }

        ValidationUtility.isNull(detallePedidoDTO,
                new DetallePedidoException(DetallePedidoServiceMessage.DETALLE_PEDIDO_NULO));
        ValidationUtility.bigDecimalIsNullOrLessZero(detallePedidoDTO.getCantidad(),
                new DetallePedidoException(DetallePedidoServiceMessage.CANTIDAD_REQUERIDA));
        ValidationUtility.bigDecimalIsNullOrLessZero(detallePedidoDTO.getValor(),
                new DetallePedidoException(DetallePedidoServiceMessage.VALOR_REQUERIDO));
        ValidationUtility.integerIsNullOrLessZero(detallePedidoDTO.getPedidoId(),
                new DetallePedidoException(DetallePedidoServiceMessage.PEDIDO_ID_REQUERIDO));
        ValidationUtility.integerIsNullOrLessZero(detallePedidoDTO.getProductoId(),
                new DetallePedidoException(DetallePedidoServiceMessage.PRODUCTO_ID_REQUERIDO));
    }
}