package com.empresa.repository;

import com.empresa.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Opcional: puedes agregar métodos personalizados si los necesitas después, ej:
    // Optional<Usuario> findByLogin(String login);
}