package com.crud.fullstack.servicios;

import com.crud.fullstack.entidades.UsuarioRol;
import com.crud.fullstack.entidades.Usuarios;

import java.util.Set;

public interface UsuarioService {
    /**
     * creamos un nuevo usuario y le pasamos un conjunto de roles asignados al usuario como una tabla intermedia
     * @param usuarios agregamos un usuario
     * @param usuarioRoles pasamos sus roles
     * @return
     * @throws Exception
     */
    public Usuarios guardarUsuario(Usuarios usuarios, Set<UsuarioRol> usuarioRoles) throws Exception;

    public Usuarios obtenerUsuario(String username);

    public void eliminarUsuario(Long usuarioId);

}
