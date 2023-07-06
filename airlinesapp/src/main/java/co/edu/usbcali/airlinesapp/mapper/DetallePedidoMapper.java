package co.edu.usbcali.airlinesapp.mapper;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.usbcali.airlinesapp.domain.DetallePedido;
import co.edu.usbcali.airlinesapp.dtos.DetallePedidoDTO;

public class DetallePedidoMapper {

	
	public static DetallePedidoDTO domainToDto(DetallePedido detallePedido){
        return DetallePedidoDTO.builder()
                .id(detallePedido.getId())
                .cantidad(detallePedido.getCantidad())
                .valor(detallePedido.getValor())
                .pedidoId(detallePedido.getPedido() == null ?
                        null : detallePedido.getPedido().getId())
                .productoId(detallePedido.getProducto() == null ?
                        null : detallePedido.getProducto().getId())
                .build();
    }

    public static DetallePedido dtoToDomain(DetallePedidoDTO detallePedidoDto){
        return DetallePedido.builder()
                .id(detallePedidoDto.getId())
                .cantidad(detallePedidoDto.getCantidad())
                .valor(detallePedidoDto.getValor())
                .build();
    }

    public static List<DetallePedidoDTO> domainToDtoList(List<DetallePedido> detallePedidos) {
        return detallePedidos.stream()
                .map(DetallePedidoMapper::domainToDto)
                .collect(Collectors.toList());
    }

    public static List<DetallePedido> dtoToDomainList(List<DetallePedidoDTO> detallePedidosDtos) {
        return detallePedidosDtos.stream()
                .map(DetallePedidoMapper::dtoToDomain)
                .collect(Collectors.toList());
    }

}
