package com.nttdata.back.service;

import com.nttdata.back.model.entity.Usuario;
import com.nttdata.back.util.InicializarUsuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Anotación de Lombok para generar automáticamente una instancia de registrador llamada "log"
@Slf4j
@Service
public class ConsultaService {

    @Autowired
    InicializarUsuario inicializarUsuario;

    /**
     * Metodo para consultar los datos del usuario por la identificación de este
     *
     * @param usuario objeto con los datos de identificación del usuario
     * @return Objeto con los datos del usuario
     */
    public List<Usuario> getUsuarioByIdentificacion(Usuario usuario) throws Exception {
        List<Usuario> usuarioTemp = new ArrayList<>();
        try {
            usuarioTemp = inicializarUsuario.getUsuarios().stream().filter(
                            user -> user.getTipoIdentificacion().equals(usuario.getTipoIdentificacion()) &&
                                    user.getNumeroIdentificacion().equals(usuario.getNumeroIdentificacion()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("{}:{}", Thread.currentThread().getStackTrace()[1].getMethodName(), e.getMessage());
            throw new Exception("Error al consultar el usuario por la identificación");
        }
        return usuarioTemp;
    }
}
