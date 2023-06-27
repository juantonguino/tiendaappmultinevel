package co.edu.usbcali.tiendaapp.service;

import co.edu.usbcali.tiendaapp.domain.Pedido;
import co.edu.usbcali.tiendaapp.dto.DetallePedidoDTO;
import co.edu.usbcali.tiendaapp.dto.PedidoDTO;
import co.edu.usbcali.tiendaapp.exceptions.ClienteException;
import co.edu.usbcali.tiendaapp.exceptions.EstadoPedidoException;
import co.edu.usbcali.tiendaapp.exceptions.PedidoException;

import java.util.List;

public interface PedidoService {
    List<PedidoDTO> obtenerTodos();

    PedidoDTO buscarPorId(Integer id) throws PedidoException;

    Pedido buscarPedidoPorId(Integer id) throws PedidoException;

    PedidoDTO guardar(PedidoDTO pedidoDTO) throws ClienteException, EstadoPedidoException, PedidoException;

    PedidoDTO actualizar(PedidoDTO pedidoDTO) throws ClienteException, EstadoPedidoException, PedidoException;
}
