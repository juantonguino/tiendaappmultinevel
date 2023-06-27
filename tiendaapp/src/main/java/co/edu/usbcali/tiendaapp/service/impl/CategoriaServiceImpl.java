package co.edu.usbcali.tiendaapp.service.impl;

import co.edu.usbcali.tiendaapp.domain.Categoria;
import co.edu.usbcali.tiendaapp.dto.CategoriaDTO;
import co.edu.usbcali.tiendaapp.exceptions.CategoriaException;
import co.edu.usbcali.tiendaapp.exceptions.messages.CategoriaServiceMessage;
import co.edu.usbcali.tiendaapp.mapper.CataegoriaMapper;
import co.edu.usbcali.tiendaapp.repository.CategoriaRepository;
import co.edu.usbcali.tiendaapp.service.CategoriaService;
import co.edu.usbcali.tiendaapp.utils.ValidationUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaDTO> obtenerTodos() {
        return CataegoriaMapper.domainCategoriaDtoList(categoriaRepository.findAllByOrderByNombreAsc());
    }

    @Override
    public CategoriaDTO buscarPorId(Integer id) throws CategoriaException {
        ValidationUtility.integerIsNullOrLessZero(id,
                new CategoriaException(CategoriaServiceMessage.ID_NO_VALIDO_MSG));

        return categoriaRepository
                .findById(id)
                .map(CataegoriaMapper::domainToDto)
                .orElseThrow(() -> new CategoriaException(String
                        .format(CategoriaServiceMessage.CATEGORIA_NO_ENCONTRADA_POR_ID, id))
                );
    }

    @Override
    public Categoria buscarCategoriaPorId(Integer id) throws CategoriaException {
        ValidationUtility.integerIsNullOrLessZero(id,
                new CategoriaException(CategoriaServiceMessage.ID_NO_VALIDO_MSG));

        return categoriaRepository
                .findById(id)
                .orElseThrow(() -> new CategoriaException(String
                        .format(CategoriaServiceMessage.CATEGORIA_NO_ENCONTRADA_POR_ID, id))
                );
    }

    @Override
    public CategoriaDTO guardar(CategoriaDTO categoriaDTO) throws CategoriaException {
        validarCategoria(categoriaDTO, false);

        Categoria categoria = CataegoriaMapper.dtoToDomain(categoriaDTO);

        return CataegoriaMapper.domainToDto(categoriaRepository.save(categoria));
    }

    @Override
    public CategoriaDTO actualiar(CategoriaDTO categoriaDTO) throws CategoriaException {
        validarCategoria(categoriaDTO, true);

        Categoria categoria = buscarCategoriaPorId(categoriaDTO.getId());

        categoria.setNombre(categoriaDTO.getNombre());
        categoria.setDescription(categoriaDTO.getDescription());

        return CataegoriaMapper.domainToDto(categoriaRepository.save(categoria));
    }

    private void validarCategoria(CategoriaDTO clienteDTO, Boolean esActualizar) throws CategoriaException {
        if (Boolean.TRUE.equals(esActualizar)){
            ValidationUtility.integerIsNullOrLessZero(clienteDTO.getId(),
                    new CategoriaException(CategoriaServiceMessage.ID_NO_VALIDO_MSG));
        }

        ValidationUtility.isNull(clienteDTO,
                new CategoriaException(CategoriaServiceMessage.CATEGORIA_NULA));
        ValidationUtility.stringIsNullOrBlank(clienteDTO.getNombre(),
                new CategoriaException(CategoriaServiceMessage.NOMBRE_REQUERIDO));
        ValidationUtility.stringIsNullOrBlank(clienteDTO.getDescription(),
                new CategoriaException(CategoriaServiceMessage.DESCRIPCION_REQUERIDA));
    }
}
