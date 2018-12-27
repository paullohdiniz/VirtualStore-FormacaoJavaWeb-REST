package br.com.virtualstore.services;

import java.util.List;

import br.com.virtualstore.domain.usuario.Usuario;

public interface UsuarioService {

	List<Usuario> findAll();
}
