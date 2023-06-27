package co.edu.usbcali.tiendaapp.service.impl;

import co.edu.usbcali.tiendaapp.domain.Categoria;
import co.edu.usbcali.tiendaapp.domain.Producto;
import co.edu.usbcali.tiendaapp.dto.ProductoDTO;
import co.edu.usbcali.tiendaapp.exceptions.CategoriaException;
import co.edu.usbcali.tiendaapp.exceptions.ProductoException;
import co.edu.usbcali.tiendaapp.exceptions.messages.ProductoServiceMessage;
import co.edu.usbcali.tiendaapp.mapper.ProductoMapper;
import co.edu.usbcali.tiendaapp.repository.ProductoRepository;
import co.edu.usbcali.tiendaapp.request.CrearProductoRequest;
import co.edu.usbcali.tiendaapp.response.CrearProductoResponse;
import co.edu.usbcali.tiendaapp.service.CategoriaService;
import co.edu.usbcali.tiendaapp.service.ProductoService;
import co.edu.usbcali.tiendaapp.utils.ValidationUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    private final ProductoMapper productoMapper;

    private final CategoriaService categoriaService;

    @Override
    public List<ProductoDTO> obtenerTodos() {
        return productoMapper.domainToDtoList(productoRepository.findAll());
    }

    @Override
    public ProductoDTO buscarPorId(Integer id) throws ProductoException {
        ValidationUtility.integerIsNullOrLessZero(id,
                new ProductoException(ProductoServiceMessage.ID_NO_VALIDO_MSG));

        return productoRepository
                .findById(id)
                .map(productoMapper::domainToDto)
                .orElseThrow(() -> new ProductoException(String
                        .format(ProductoServiceMessage.PRODUCTO_NO_ENCONTRADA_POR_ID, id))
                );
    }

    @Override
    public Producto buscarProductoPorId(Integer id) throws ProductoException {
        ValidationUtility.integerIsNullOrLessZero(id,
                new ProductoException(ProductoServiceMessage.ID_NO_VALIDO_MSG));

        return productoRepository
                .findById(id)
                .orElseThrow(() -> new ProductoException(String
                        .format(ProductoServiceMessage.PRODUCTO_NO_ENCONTRADA_POR_ID, id))
                );
    }

    @Override
    public ProductoDTO guardar(ProductoDTO productoDTO) throws CategoriaException, ProductoException {
        validarProducto(productoDTO, false);

        Producto producto = productoMapper.dtoToDomain(productoDTO);
        producto.setCategoria(categoriaService.buscarCategoriaPorId(productoDTO.getCategoriaId()));

        return productoMapper.domainToDto(productoRepository.save(producto));
    }

    @Override
    public ProductoDTO actualizar(ProductoDTO productoDTO) throws CategoriaException, ProductoException {
        validarProducto(productoDTO, true);

        Producto producto = productoMapper.dtoToDomain(productoDTO);
        producto.setCategoria(categoriaService.buscarCategoriaPorId(productoDTO.getCategoriaId()));

        return productoMapper.domainToDto(productoRepository.save(producto));
    }

    @Override
    public CrearProductoResponse guardarNuevo( CrearProductoRequest crearProductoRequest) throws Exception {
        Categoria categoria = categoriaService.buscarCategoriaPorId(crearProductoRequest.getCategoriaId());

        // Validar si ya existe la referencia en la Categoría
        boolean existeReferenciaEnCategoria = productoRepository
                .existsByCategoriaIdAndReferencia(crearProductoRequest.getCategoriaId(), crearProductoRequest.getReferencia());
        if (existeReferenciaEnCategoria) throw new Exception(
                String.format(ProductoServiceMessage.EXISTE_REFERENCIA_EN_CATEGORIA,
                        crearProductoRequest.getReferencia(), (categoria.getId()+" - "+categoria.getNombre()))
        );

        // Mapear del request al Producto
        Producto producto = productoMapper.crearRequestToDomain(crearProductoRequest);

        // Inyectar la categoría buscada al Objeto del dominio Producto
        producto.setCategoria(categoria);

        return productoMapper.crearDomainToResponse(productoRepository.save(producto));
    }

    private void validarProducto(ProductoDTO productoDTO, Boolean esActualizar) throws ProductoException {
        if (Boolean.TRUE.equals(esActualizar)){
            ValidationUtility.isNull(productoDTO.getId(),
                    new ProductoException(ProductoServiceMessage.ID_REQUERIDO));
        }

        ValidationUtility.isNull(productoDTO,
                new ProductoException(ProductoServiceMessage.PRODUCTO_NULO));
        ValidationUtility.stringIsNullOrBlank(productoDTO.getReferencia(),
                new ProductoException(ProductoServiceMessage.REFERENCIA_REQUERIDA));
        ValidationUtility.stringIsNullOrBlank(productoDTO.getNombre(),
                new ProductoException(ProductoServiceMessage.NOMBRE_REQUERIDO));
        ValidationUtility.stringIsNullOrBlank(productoDTO.getDescripcion(),
                new ProductoException(ProductoServiceMessage.DESCRIPCION_REQUERIDA));
        ValidationUtility.bigDecimalIsNullOrLessZero(productoDTO.getPrecioUnitario(),
                new ProductoException(ProductoServiceMessage.PRECIO_UNITARIO_REQUERIDO));
        ValidationUtility.bigDecimalIsNullOrLessZero(productoDTO.getUnidadesDisponibles(),
                new ProductoException(ProductoServiceMessage.UNIDADES_DISPONIBLES_REQUERIDO));
        ValidationUtility.integerIsNullOrLessZero(productoDTO.getCategoriaId(),
                new ProductoException(ProductoServiceMessage.CATEGORIA_ID_REQUERIDO));
    }
}
