package com.nttdata.back.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Anotación Lombok para generar métodos getters, setters, equals, hashCode y toString
@Data
// Anotación Lombok para generar un constructor con todos los argumentos
@AllArgsConstructor
// Anotación Lombok para generar un constructor sin argumentos
@NoArgsConstructor
public class Usuario {
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    private String direccion;
    private String ciudadResidencia;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
}
