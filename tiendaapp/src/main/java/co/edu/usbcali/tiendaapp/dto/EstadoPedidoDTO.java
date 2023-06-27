package co.edu.usbcali.tiendaapp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstadoPedidoDTO {

    private Integer id;

    @NotNull(message = "La descripcion es requeridad")
    private String descripcion;
}
