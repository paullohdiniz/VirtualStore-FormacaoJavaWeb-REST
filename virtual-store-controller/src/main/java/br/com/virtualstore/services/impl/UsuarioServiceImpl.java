package br.com.virtualstore.services.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.virtualstore.domain.usuario.Usuario;
import br.com.virtualstore.services.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

	private static final Logger log = Logger.getLogger(UsuarioServiceImpl.class.getName());

	Usuario usuario;

	public UsuarioServiceImpl(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> findAll() {

		log.log(Level.FINE, "M=" + Thread.currentThread().getStackTrace()[1].getMethodName());
		
		List<Usuario> usuarios = null;
		
		try {
			
//			UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
//			usuarios = usuarioDAOImpl.getAll(Usuario.class);

		} catch (Exception e) {
			log.log(Level.SEVERE, e.toString(), e);
		} finally {
		}
		
		return usuarios;

	}
}
