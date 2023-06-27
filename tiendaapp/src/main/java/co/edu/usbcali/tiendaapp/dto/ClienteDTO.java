package co.edu.usbcali.tiendaapp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDTO {

    private Integer id;

    @NotNull(message = "El nombre es requerido")
    private String nombres;

    @NotNull(message = "Los apellidos son requeridos")
    private String apellidos;

    @NotNull(message = "el documento es requerido")
    private String documento;

    @NotNull(message = "el estado es requerido")
    private String estado;

    @NotNull(message = "el tipo documento es requerido")
    private Integer tipoDocumentoId;
}
