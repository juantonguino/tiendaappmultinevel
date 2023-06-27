package co.edu.usbcali.tiendaapp.service;

import co.edu.usbcali.tiendaapp.domain.Categoria;
import co.edu.usbcali.tiendaapp.dto.CategoriaDTO;
import co.edu.usbcali.tiendaapp.exceptions.CategoriaException;

import java.util.List;

public interface CategoriaService {

    List<CategoriaDTO> obtenerTodos();

    CategoriaDTO buscarPorId(Integer id) throws CategoriaException;

    CategoriaDTO guardar(CategoriaDTO categoriaDTO) throws CategoriaException;

    CategoriaDTO actualiar(CategoriaDTO categoriaDTO) throws CategoriaException;

    Categoria buscarCategoriaPorId(Integer id) throws CategoriaException;
}
