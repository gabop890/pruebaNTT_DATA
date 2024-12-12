package com.nttdata.back.util;

import com.nttdata.back.model.entity.Usuario;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// Anotación de Spring para indicar que esta clase es un componente administrado por Spring
@Getter
@Setter
@Component
public class InicializarUsuario {

    private List<Usuario> usuarios = new ArrayList<>();

    @PostConstruct
    public void init() {
        usuarios.add(new Usuario("Juan", "Andrés", "Martínez", "Gómez", "3101234567", "Calle 12 #34-56", "Bogotá", "C", "84736592"));
        usuarios.add(new Usuario("María", "Fernanda", "López", "Pérez", "3129876543", "Carrera 45 #78-90", "Medellín", "P", "39284716"));
        usuarios.add(new Usuario("Carlos", "Alberto", "García", "Torres", "3204567890", "Avenida Siempreviva #123", "Cali", "C", "23445322"));
        usuarios.add(new Usuario("Luisa", "Marcela", "Rodríguez", "Hernández", "3145678901", "Calle 50 #60-70", "Barranquilla", "C", "72849531"));
        usuarios.add(new Usuario("Jorge", "Alejandro", "Torres", "Rivera", "3187654321", "Carrera 10 #20-30", "Cartagena", "C", "51628374"));
        usuarios.add(new Usuario("Sofía", "Isabel", "Gómez", "Ramírez", "3198765432", "Calle 25 #35-45", "Bucaramanga", "P", "63927485"));
        usuarios.add(new Usuario("Felipe", "José", "Ramírez", "Vargas", "3165432109", "Avenida Los Robles #200", "Manizales", "C", "28473619"));
        usuarios.add(new Usuario("Camila", "Daniela", "Vargas", "Molina", "3154321987", "Carrera 8 #16-26", "Pereira", "C", "47392816"));
        usuarios.add(new Usuario("Diego", "Santiago", "Ríos", "Morales", "3112345678", "Calle 100 #10-20", "Cúcuta", "P", "52839147"));
        usuarios.add(new Usuario("Valentina", "Alejandra", "Morales", "Fernández", "3176543210", "Carrera 32 #40-50", "Ibagué", "C", "6546846"));
    }

}
