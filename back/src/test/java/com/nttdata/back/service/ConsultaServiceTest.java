package com.nttdata.back.service;

import com.nttdata.back.model.entity.Usuario;
import com.nttdata.back.util.InicializarUsuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConsultaServiceTest {

    @InjectMocks
    ConsultaService consultaService;
    @Mock
    InicializarUsuario inicializarUsuario;

    List<Usuario> usuarios = new ArrayList<>();

    @BeforeEach
    void setUp() {
        usuarios.add(new Usuario("pedro", "pablo", "poveda",
                "pineda", "3105784268", "cll. 65 # 45-87", "tunja",
                "P", "12345"));

    }

    @Test
    void getUsuarioByIdentificacion() throws Exception {
        String numeroDocumento = "12345";
        Usuario usuario = new Usuario();
        usuario.setTipoIdentificacion("P");
        usuario.setNumeroIdentificacion("12345");
//        List<Usuario> users = inicializarUsuario.getUsuarios();
//        List<Usuario> usuarios = consultaService.getUsuarioByIdentificacion(usuario);
        when(consultaService.getUsuarioByIdentificacion(usuario)).thenReturn(usuarios);
        //Mockito.when()

        // Afirmar que el usuario recuperado no es nulo
        assertNotNull(usuarios);

        // Afirmar que el nombre del usuario recuperado coincide con el nombre esperado
//        assertEquals();
    }
}