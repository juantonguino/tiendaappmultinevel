package co.edu.usbcali.tiendaapp.mapper;

import co.edu.usbcali.tiendaapp.domain.DetallePedido;
import co.edu.usbcali.tiendaapp.dto.DetallePedidoDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DetallePedidoMapper extends Converter<DetallePedidoDTO, DetallePedido> {

    public DetallePedidoMapper() {
        super(DetallePedidoMapper::dtoToDomainImpl, DetallePedidoMapper::domainToDtoImpl);
    }

    public static DetallePedidoDTO domainToDtoImpl(DetallePedido detallePedido){
        return DetallePedidoDTO.builder()
                .id(detallePedido.getId())
                .pedidoId((detallePedido.getPedido()==null)?null: detallePedido.getPedido().getId())
                .productoId((detallePedido.getPedido()==null)?null: detallePedido.getProducto().getId())
                .cantidad(detallePedido.getCantidad())
                .valor(detallePedido.getValor())
                .build();
    }

    public static DetallePedido dtoToDomainImpl(DetallePedidoDTO detallePedidoDTO){
        return DetallePedido.builder()
                .id(detallePedidoDTO.getId())
                .cantidad(detallePedidoDTO.getCantidad())
                .valor(detallePedidoDTO.getValor())
                .build();
    }
}
