package com.crud.fullstack.repositorios;

import com.crud.fullstack.entidades.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {

    /**
     * Spring y jpa reconoce este nombre y realiza la busqueda por lo cual no requiere implementacion.
     * @param username
     * @return
     */
    public Usuarios findByUsername(String username);

}
