package co.edu.usbcali.tiendaapp.mapper;

import co.edu.usbcali.tiendaapp.domain.Pedido;
import co.edu.usbcali.tiendaapp.domain.Producto;
import co.edu.usbcali.tiendaapp.dto.PedidoDTO;
import co.edu.usbcali.tiendaapp.dto.ProductoDTO;
import co.edu.usbcali.tiendaapp.request.CrearProductoRequest;
import co.edu.usbcali.tiendaapp.response.CrearProductoResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductoMapper extends Converter<ProductoDTO, Producto>{

    public ProductoMapper() {
        super(ProductoMapper::dtoToDomainImpl, ProductoMapper::domainToDtoImpl);
    }

    public static ProductoDTO domainToDtoImpl(Producto producto){
        return ProductoDTO.builder()
                .id(producto.getId())
                .categoriaId((producto.getCategoria()==null)? null: producto.getCategoria().getId())
                .referencia(producto.getReferencia())
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .precioUnitario(producto.getPrecioUnitario())
                .unidadesDisponibles(producto.getUnidadesDisponibles())
                .build();
    }

    public static Producto dtoToDomainImpl(ProductoDTO productoDTO){
        return Producto.builder()
                .id(productoDTO.getId())
                .referencia(productoDTO.getReferencia())
                .nombre(productoDTO.getNombre())
                .descripcion(productoDTO.getDescripcion())
                .precioUnitario(productoDTO.getPrecioUnitario())
                .unidadesDisponibles(productoDTO.getUnidadesDisponibles())
                .build();
    }

    public Producto crearRequestToDomain(CrearProductoRequest crearProductoRequest){
        return Producto.builder()
                .referencia(crearProductoRequest.getReferencia())
                .nombre(crearProductoRequest.getNombre())
                .descripcion(crearProductoRequest.getDescripcion())
                .precioUnitario(crearProductoRequest.getPrecioUnitario())
                .unidadesDisponibles(crearProductoRequest.getPrecioUnitario())
                .build();
    }

    public CrearProductoResponse crearDomainToResponse(Producto producto){
        return CrearProductoResponse.builder()
                .id(producto.getId())
                .referencia(producto.getReferencia())
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .precioUnitario(producto.getPrecioUnitario())
                .unidadesDisponibles(producto.getPrecioUnitario())
                .build();
    }
}
