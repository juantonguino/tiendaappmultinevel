package co.edu.usbcali.tiendaapp.response;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CrearProductoResponse {

    private Integer id;

    private String referencia;

    private String nombre;

    private String descripcion;

    private BigDecimal precioUnitario;

    private BigDecimal unidadesDisponibles;

    private Integer categoriaId;
}
