package com.carrito;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.carrito.controller.ProductoController;
import com.carrito.repository.ProductoRepository;

@WebMvcTest(ProductoController.class)
public class ProductoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductoRepository productoRepository;

    @Test
    public void testObtenerProductosRetornaStatus200OK() throws Exception {
        when(productoRepository.findAll()).thenReturn(List.of());

        mockMvc.perform(get("/api/productos"))
               .andExpect(status().isOk());
    }
}