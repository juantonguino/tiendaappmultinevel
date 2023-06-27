package co.edu.usbcali.tiendaapp.mapper;

import co.edu.usbcali.tiendaapp.domain.Cliente;
import co.edu.usbcali.tiendaapp.dto.ClienteDTO;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper extends Converter<ClienteDTO, Cliente>{

    public ClienteMapper() {
        super(ClienteMapper::dtoToDomainImpl, ClienteMapper::domainToDtoImpl);
    }

    public static Cliente dtoToDomainImpl(ClienteDTO clienteDTO){
        return Cliente.builder()
                .id(clienteDTO.getId())
                .nombres(clienteDTO.getNombres())
                .apellidos(clienteDTO.getApellidos())
                .documento(clienteDTO.getDocumento())
                .estado(clienteDTO.getEstado())
                .build();
    }

    public static ClienteDTO domainToDtoImpl(Cliente cliente){
        return ClienteDTO.builder()
                .id(cliente.getId())
                .nombres(cliente.getNombres())
                .apellidos(cliente.getApellidos())
                .documento(cliente.getDocumento())
                .estado(cliente.getEstado())
                .tipoDocumentoId((cliente.getTipoDocumento()==null)?
                        null: cliente.getTipoDocumento().getId())
                .build();
    }
}
