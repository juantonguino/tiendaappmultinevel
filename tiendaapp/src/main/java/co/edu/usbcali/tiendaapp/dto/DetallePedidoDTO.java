package co.edu.usbcali.tiendaapp.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedidoDTO {

    private Integer id ;

    @NotNull(message = "El id de pedido es requerido")
    private Integer pedidoId;

    @NotNull(message = "El id de producto es requerido")
    private Integer productoId;

    @NotNull(message = "La cantidad es requerida")
    private BigDecimal cantidad;

    @NotNull(message = "El valor es requerido")
    private BigDecimal valor;
}
