package co.edu.usbcali.tiendaapp.mapper;

import co.edu.usbcali.tiendaapp.domain.TipoDocumento;
import co.edu.usbcali.tiendaapp.dto.TipoDocumentoDTO;
import org.springframework.stereotype.Component;

@Component
public class TipoDocumentoMapper extends Converter<TipoDocumentoDTO, TipoDocumento> {

    public TipoDocumentoMapper() {
        super(TipoDocumentoMapper::dtoToDomainImpl, TipoDocumentoMapper::domainToDtoImpl);
    }
    public static TipoDocumentoDTO domainToDtoImpl(TipoDocumento tipoDocumento){
        return TipoDocumentoDTO.builder()
                .id(tipoDocumento.getId())
                .descripcion(tipoDocumento.getDescripcion())
                .build();
    }

    public static TipoDocumento dtoToDomainImpl(TipoDocumentoDTO productoDTO){
        return TipoDocumento.builder()
                .id(productoDTO.getId())
                .descripcion(productoDTO.getDescripcion())
                .build();
    }
}
