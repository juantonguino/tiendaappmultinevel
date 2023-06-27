package co.edu.usbcali.tiendaapp.mapper;

import co.edu.usbcali.tiendaapp.domain.Categoria;
import co.edu.usbcali.tiendaapp.dto.CategoriaDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CataegoriaMapper {

    public static CategoriaDTO domainToDto(Categoria categoria){
        return CategoriaDTO.builder()
                .id(categoria.getId())
                .nombre(categoria.getNombre())
                .description(categoria.getDescription())
                .build();
    }

    public static Categoria dtoToDomain(CategoriaDTO categoriaDTO) {
        return Categoria.builder()
                .id(categoriaDTO.getId())
                .nombre(categoriaDTO.getNombre())
                .description(categoriaDTO.getDescription())
                .build();
    }

    public static List<CategoriaDTO> domainCategoriaDtoList(List<Categoria> categoriaList){
        return categoriaList.stream().map(CataegoriaMapper::domainToDto).collect(Collectors.toList());
    }

    public static List<Categoria> dtoToDomainList(List<CategoriaDTO> categoriaDTOList){
        return categoriaDTOList.stream().map(CataegoriaMapper::dtoToDomain).collect(Collectors.toList());
    }
}
