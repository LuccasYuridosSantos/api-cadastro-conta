package com.bancoz.cadastro.conta.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancoz.cadastro.conta.model.Usuario;
import com.bancoz.cadastro.conta.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> post(@Valid @RequestBody  Usuario usuario) {
		return usuarioService.cadastrarUsuario(usuario);
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		return usuarioService.findAllUsuario();
	}
	
}
