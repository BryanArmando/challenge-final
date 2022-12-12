package com.crud.fullstack.repositorios;

import com.crud.fullstack.entidades.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * hereda de jpa y se llama a la entidad y su id
 */
public interface RolRepository extends JpaRepository<Rol,Long> {
}
