package com.crud.fullstack;

import com.crud.fullstack.entidades.Rol;
import com.crud.fullstack.entidades.UsuarioRol;
import com.crud.fullstack.entidades.Usuarios;
import com.crud.fullstack.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

/**
 * al implementar commandline cuando se compila se puede ejecutar lo que va debajo del main
 * es decir lo que sigue de la aplicacion al iniciar
 * se colocan datos para que pueda iniciar sesión y obtener el token con username y password
 */
@SpringBootApplication
public class FullstackApplication implements CommandLineRunner {

	@Autowired
	private UsuarioService usuarioService;


	public static void main(String[] args) {
		SpringApplication.run(FullstackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuarios usuarios = new Usuarios();

		usuarios.setNombre("Bryan");
		usuarios.setApellido("Quisaguano");
		usuarios.setUsername("bryan");
		usuarios.setPassword("12345");
		usuarios.setEmail("bryan@gmail.com");
		usuarios.setTelefono("1234567");
		usuarios.setPerfil("foto.png");

		Rol rol = new Rol();
		rol.setRolId(1L);
		rol.setNombre("ADMIN");

		Set<UsuarioRol> usuarioRols = new HashSet<>();
		UsuarioRol usuarioRol = new UsuarioRol();
		usuarioRol.setRol(rol);
		usuarioRol.setUsuarios(usuarios);
		usuarioRols.add(usuarioRol);

		Usuarios usuarioGuardado = usuarioService.guardarUsuario(usuarios, usuarioRols);
		System.out.println(usuarioGuardado.getUsername());

	}


}
