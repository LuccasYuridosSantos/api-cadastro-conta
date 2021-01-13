package com.bancoz.cadastro.conta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bancoz.cadastro.conta.model.Usuario;
import com.bancoz.cadastro.conta.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	// método de busca por todos usuarios cadastrados
	public ResponseEntity<List<Usuario>> findAllUsuario() {
		List<Usuario> usuarios = repository.findAll();
		if (usuarios.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		return ResponseEntity.ok(repository.findAll());
	}

	// método de verificação de usuario existente
	public boolean usuarioExiste(Usuario usuario) {
		Optional<Usuario> userEmail = repository.findByEmail(usuario.getEmail());
		Optional<Usuario> userCpf = repository.findByCpf(usuario.getCpf());

		if (userEmail.isPresent()) {
			return true;
		}
		if (userCpf.isPresent()) {
			return true;
		}

		return false;
	}

	// método de cadastro de usuario
	public ResponseEntity<Usuario> cadastrarUsuario(Usuario usuario) {

		if (usuarioExiste(usuario)) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
	}

}
