package com.nttdata.back.controller;

import com.nttdata.back.model.entity.Usuario;
import com.nttdata.back.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// Anotación de Spring para indicar que esta clase es un controlador REST
@RestController
// Mapeo base para todos los mapeos de solicitudes en este controlador
@RequestMapping(value = "/consultar")
public class ConsultaController {

    // Anotación de Autowired para inyectar la dependencia UserRepository
    @Autowired
    private ConsultaService consultaService;

    /**
     * End point para consultar los datos del usuario por la identificación de este
     *
     * @param usuario objeto con los datos de identificación del usuario
     * @return Objeto con los datos del usuario
     */
    @PostMapping()
    private ResponseEntity<Usuario> getUsuarioByIdentificacion(@RequestBody Usuario usuario) {
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuarioTemp = new Usuario();
        try {
            usuarios = consultaService.getUsuarioByIdentificacion(usuario);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(usuario);
        }
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(usuarios.get(0));
        }
    }
}
