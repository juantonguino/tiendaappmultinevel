package co.edu.usbcali.tiendaapp.service;

import co.edu.usbcali.tiendaapp.domain.Cliente;
import co.edu.usbcali.tiendaapp.dto.ClienteDTO;
import co.edu.usbcali.tiendaapp.exceptions.ClienteException;
import co.edu.usbcali.tiendaapp.exceptions.TipoDocumentoException;
import co.edu.usbcali.tiendaapp.request.CrearClienteRequest;
import co.edu.usbcali.tiendaapp.response.CrearClienteResponse;

import java.util.List;

public interface ClienteService {

    List<ClienteDTO> obtenerTodos();

    ClienteDTO buscarPorId(Integer id) throws Exception;

    Cliente buscarClientePorId(Integer id) throws ClienteException;

    ClienteDTO guardar(ClienteDTO clienteDTO) throws Exception;

    ClienteDTO actualizar(ClienteDTO clienteDTO) throws ClienteException, TipoDocumentoException;

    CrearClienteResponse crearCliente(CrearClienteRequest crearClienteRequest) throws Exception;
}
