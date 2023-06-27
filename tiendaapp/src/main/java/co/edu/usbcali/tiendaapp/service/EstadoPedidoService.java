package co.edu.usbcali.tiendaapp.service;

import co.edu.usbcali.tiendaapp.domain.EstadoPedido;
import co.edu.usbcali.tiendaapp.dto.EstadoPedidoDTO;
import co.edu.usbcali.tiendaapp.exceptions.EstadoPedidoException;

import java.util.List;

public interface EstadoPedidoService {

    List<EstadoPedidoDTO> obtenerTodos();

    EstadoPedidoDTO buscarPorId(Integer id) throws EstadoPedidoException;

    EstadoPedido buscarEstadoPedidoPorId(Integer id) throws EstadoPedidoException;
}
