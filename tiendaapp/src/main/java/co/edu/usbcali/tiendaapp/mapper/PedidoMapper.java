package co.edu.usbcali.tiendaapp.mapper;

import co.edu.usbcali.tiendaapp.domain.EstadoPedido;
import co.edu.usbcali.tiendaapp.domain.Pedido;
import co.edu.usbcali.tiendaapp.dto.EstadoPedidoDTO;
import co.edu.usbcali.tiendaapp.dto.PedidoDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PedidoMapper extends Converter<PedidoDTO, Pedido>{

    public PedidoMapper() {
        super(PedidoMapper::dtoToDomainImpl, PedidoMapper::domainToDtoImpl);
    }

    public static PedidoDTO domainToDtoImpl(Pedido pedido){
        return PedidoDTO.builder()
                .id(pedido.getId())
                .clienteId((pedido.getCliente()==null)? null: pedido.getCliente().getId())
                .estadoPedidoId((pedido.getEstadoPedido()==null)? null : pedido.getEstadoPedido().getId())
                .fecha(pedido.getFecha())
                .total(pedido.getTotal())
                .build();
    }

    public static Pedido dtoToDomainImpl(PedidoDTO pedidoDTO){
        return Pedido.builder()
                .id(pedidoDTO.getId())
                .fecha(pedidoDTO.getFecha())
                .total(pedidoDTO.getTotal())
                .build();
    }
}
