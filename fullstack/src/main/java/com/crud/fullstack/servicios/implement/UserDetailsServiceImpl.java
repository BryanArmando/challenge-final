package com.crud.fullstack.servicios.implement;

import com.crud.fullstack.entidades.Usuarios;
import com.crud.fullstack.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * vamos a cargar un usuario por el username
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios usuarios = this.usuarioRepository.findByUsername(username);
        if (usuarios == null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return usuarios;
    }
}
