package com.crud.fullstack.servicios.implement;

import com.crud.fullstack.entidades.UsuarioRol;
import com.crud.fullstack.entidades.Usuarios;
import com.crud.fullstack.repositorios.RolRepository;
import com.crud.fullstack.repositorios.UsuarioRepository;
import com.crud.fullstack.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RolRepository rolRepository;

    /**
     * guardamos un usuario junto con los roles asignados
     * buscamos si el usuario existe en nuestra base caso contrario analizamos los roles disponibles y se guardan
     * ademas agregamos al usuario los roles obtenidos
     * por ultimo al guardamos  el usuario
     * @param usuarios agregamos un usuario
     * @param usuarioRoles pasamos sus roles
     * @return usuario guardado
     * @throws Exception
     */
    @Override
    public Usuarios guardarUsuario(Usuarios usuarios, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuarios usuarioLocal = usuarioRepository.findByUsername(usuarios.getUsername());
        if (usuarioLocal !=null){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya esta presente");
        }else {
            for (UsuarioRol usuarioRol:usuarioRoles){
                rolRepository.save(usuarioRol.getRol());
            }
            usuarios.getUsuarioRols().addAll(usuarioRoles);
            usuarioLocal=usuarioRepository.save(usuarios);
        }
        return usuarioLocal;
    }

    @Override
    public Usuarios obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }
}
