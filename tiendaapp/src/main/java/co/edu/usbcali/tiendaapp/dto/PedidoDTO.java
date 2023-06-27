package co.edu.usbcali.tiendaapp.dto;

import co.edu.usbcali.tiendaapp.domain.Cliente;
import co.edu.usbcali.tiendaapp.domain.EstadoPedido;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoDTO {

    private Integer id;

    @NotNull(message = "El id de cliente es requerido")
    private Integer clienteId;

    @NotNull(message = "El id del estado de pedido es requrido")
    private Integer estadoPedidoId;

    @NotNull(message = "La fecha es requerida")
    private Date fecha;

    @NotNull(message = "El valor todal es requerido")
    private BigDecimal total;
}
