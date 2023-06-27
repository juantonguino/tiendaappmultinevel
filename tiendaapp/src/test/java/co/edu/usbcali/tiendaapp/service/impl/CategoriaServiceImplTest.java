package co.edu.usbcali.tiendaapp.service.impl;

import ch.qos.logback.core.encoder.EchoEncoder;
import co.edu.usbcali.tiendaapp.domain.Categoria;
import co.edu.usbcali.tiendaapp.dto.CategoriaDTO;
import co.edu.usbcali.tiendaapp.exceptions.CategoriaException;
import co.edu.usbcali.tiendaapp.exceptions.messages.CategoriaServiceMessage;
import co.edu.usbcali.tiendaapp.repository.CategoriaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoriaServiceImplTest {

    @Mock
    private CategoriaRepository categoriaRepository;

    @InjectMocks
    private CategoriaServiceImpl categoriaService;

    @Test
    void obtenerTodasTest(){
        List<Categoria> categorias= Arrays.asList(
                Categoria.builder().id(1).nombre("C1").description("C1").build(),
                Categoria.builder().id(2).nombre("C2").description("C2").build(),
                Categoria.builder().id(3).nombre("C3").description("C3").build()
        );
        BDDMockito.given(categoriaRepository.findAllByOrderByNombreAsc()).willReturn(categorias);


        List<CategoriaDTO> obtener = categoriaService.obtenerTodos();

        assertEquals(3, obtener.size());
    }

    @Test
    void guardarOk() throws CategoriaException {
        CategoriaDTO catToSave = CategoriaDTO.builder()
                .nombre("C2").description("C2")
                .build();

        BDDMockito.given(categoriaRepository.save(Mockito.any(Categoria.class)))
                .willReturn(Categoria.builder().id(2).nombre("C2").description("C2").build());
        CategoriaDTO categoriaResult = categoriaService.guardar(catToSave);
        assertNotNull(categoriaResult);
        assertEquals(2, categoriaResult.getId());
    }

    @Test
    void guardarError() throws CategoriaException {
        CategoriaDTO catToSave = CategoriaDTO.builder()
                .description("C2")
                .build();

        Exception exception= assertThrows(Exception.class, ()->categoriaService.guardar(catToSave));
        assertEquals(CategoriaServiceMessage.NOMBRE_REQUERIDO, exception.getMessage());
    }
}