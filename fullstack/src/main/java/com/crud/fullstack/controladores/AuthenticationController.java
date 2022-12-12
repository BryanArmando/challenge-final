package com.crud.fullstack.controladores;

import com.crud.fullstack.configuraciones.JwtUtils;
import com.crud.fullstack.entidades.JwtRequest;
import com.crud.fullstack.entidades.JwtResponse;
import com.crud.fullstack.entidades.Usuarios;
import com.crud.fullstack.servicios.implement.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/generate-token")
    public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            autenticar(jwtRequest.getUsername(),jwtRequest.getPassword());
        }catch (Exception exception) {
            exception.printStackTrace();
            throw  new Exception("Usuario no encontrado");
        }

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));

    }

    private void autenticar(String username,String password)throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException exception){
            throw new Exception("USUARIO DESHABILITADO" + exception.getMessage());
        }catch (BadCredentialsException e){
            throw new Exception("Credenciales inválidas " + e.getMessage());
        }
    }

    @GetMapping("/actual-usuario")
    public Usuarios obtenerUsuarioActual(Principal principal){
        return (Usuarios) this.userDetailsService.loadUserByUsername(principal.getName());
    }
}
