package co.edu.usbcali.tiendaapp.mapper;

import co.edu.usbcali.tiendaapp.domain.EstadoPedido;
import co.edu.usbcali.tiendaapp.dto.EstadoPedidoDTO;
import org.springframework.stereotype.Component;

@Component
public class EstadoPedidoMapper extends Converter<EstadoPedidoDTO, EstadoPedido> {

    public EstadoPedidoMapper() {
        super(EstadoPedidoMapper::dtoToDomainImpl, EstadoPedidoMapper::domainToDtoImpl);
    }

    public static EstadoPedidoDTO domainToDtoImpl(EstadoPedido estadoPedido){
        return EstadoPedidoDTO.builder()
                .id(estadoPedido.getId())
                .descripcion(estadoPedido.getDescripcion())
                .build();
    }

    public static EstadoPedido dtoToDomainImpl(EstadoPedidoDTO estadoPedidoDTO){
        return EstadoPedido.builder()
                .id(estadoPedidoDTO.getId())
                .descripcion(estadoPedidoDTO.getDescripcion())
                .build();
    }
}
