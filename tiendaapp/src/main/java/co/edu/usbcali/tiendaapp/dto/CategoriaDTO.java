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
public class CategoriaDTO {

    private Integer id;

    @NotNull(message = "el nombre es requerido")
    private String nombre;

    @NotNull(message = "la descripcion es requerido")
    private String description;
}
