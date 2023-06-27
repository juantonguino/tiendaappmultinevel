package co.edu.usbcali.tiendaapp.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CrearProductoRequest {

    @NotNull(message="")
    private String referencia;

    @NotNull(message = "")
    private String nombre;

    private String descripcion;

    private BigDecimal precioUnitario;

    private BigDecimal unidadesDisponibles;

    private Integer categoriaId;
}
