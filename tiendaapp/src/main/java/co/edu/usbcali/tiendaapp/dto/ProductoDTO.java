package co.edu.usbcali.tiendaapp.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDTO {

    private Integer id;

    @NotNull(message = "el id de la categoria es erquerido")
    private Integer categoriaId;

    @NotNull(message = "La referencia es requerida")
    private String referencia;

    @NotNull(message = "El nombre del producto es requerido")
    private String nombre;

    @NotNull(message = "La descripcion del producto es requerida")
    private String descripcion;

    @NotNull(message = "El presio unidatio del producto es requerido")
    private BigDecimal precioUnitario;

    @NotNull(message = "Las unidades disponibles del producto son requeridas")
    private BigDecimal unidadesDisponibles;
}
