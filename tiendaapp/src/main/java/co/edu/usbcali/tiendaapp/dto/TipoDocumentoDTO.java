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
public class TipoDocumentoDTO {

    private Integer id;

    @NotNull(message = "La descripcion es requerida")
    private String descripcion;
}
