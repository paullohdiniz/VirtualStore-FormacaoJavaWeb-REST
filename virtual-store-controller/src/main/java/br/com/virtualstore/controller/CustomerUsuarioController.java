package br.com.virtualstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.virtualstore.domain.usuario.Usuario;
import br.com.virtualstore.services.UsuarioService;
import br.com.virtualstore.services.impl.UsuarioServiceImpl;

@RestController
@RequestMapping("/usuario")
public class CustomerUsuarioController {

	
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
//	@PostMapping
//	public Usuario adicionar(@Valid @RequestBody Usuario usuario) {
//		return usuario.save(usuario);
//	}
	
	@GetMapping
	public List<Usuario> listar() {
		//return usuarioService.findAll();
		return null;
	}
	
//	@GetMapping("/{id}")
//	public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
//		Usuario contato = contatos.findOne(id);
//		
//		if (contato == null) {
//			return ResponseEntity.notFound().build();
//		}
//		
//		return ResponseEntity.ok(contato);
//	}
//	
//	@PutMapping("/{id}")
//	public ResponseEntity<Usuario> atualizar(@PathVariable Long id, 
//			@Valid @RequestBody Usuario contato) {
//		Usuario existente = contatos.findOne(id);
//		
//		if (existente == null) {
//			return ResponseEntity.notFound().build();
//		}
//		
//		BeanUtils.copyProperties(contato, existente, "id");
//		
//		existente = contatos.save(existente);
//		
//		return ResponseEntity.ok(existente);
//	}
//
//	@DeleteMapping("/{id}")
//	public ResponseEntity<Void> remover(@PathVariable Long id) {
//		Usuario contato = contatos.findOne(id);
//		
//		if (contato == null) {
//			return ResponseEntity.notFound().build();
//		}
//		
//		contatos.delete(contato);
//		
//		return ResponseEntity.noContent().build();
//	}

}
