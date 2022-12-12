package com.crud.fullstack.controladores;

import com.crud.fullstack.entidades.Rol;
import com.crud.fullstack.entidades.UsuarioRol;
import com.crud.fullstack.entidades.Usuarios;
import com.crud.fullstack.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/")
    public Usuarios guardarUsuario(@RequestBody Usuarios usuarios)throws Exception{
        usuarios.setPerfil("default.png");
        Set<UsuarioRol> roles = new HashSet<>();

        Rol rol = new Rol();
        rol.setRolId(2L);
        rol.setNombre("NORMAL");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuarios(usuarios);
        usuarioRol.setRol(rol);

        roles.add(usuarioRol);
        return usuarioService.guardarUsuario(usuarios, roles);
    }

    @GetMapping("/{username}")
    public Usuarios obtenerUusario(@PathVariable("username") String username){
        return usuarioService.obtenerUsuario(username);
    }

    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId){
        usuarioService.eliminarUsuario(usuarioId);

    }
}
