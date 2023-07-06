package co.edu.usbcali.airlinesapp.services;

import java.util.List;

import co.edu.usbcali.airlinesapp.domain.DetallePedido;
import co.edu.usbcali.airlinesapp.dtos.DetallePedidoDTO;

public interface DetallePedidoService {
	
	public List<DetallePedido> findAll();
	
	public DetallePedido findById(Long id);
	
	public DetallePedido save(DetallePedido detallePedido);
	
	public void delete(Long id);
	
	DetallePedidoDTO update(DetallePedidoDTO detallePedidoDTO);

}
