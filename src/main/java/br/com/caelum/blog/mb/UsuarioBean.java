package br.com.caelum.blog.mb;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.blog.dao.UsuarioDao;
import br.com.caelum.blog.entity.Usuario;

@Named
@RequestScoped
public class UsuarioBean {
	
	@Inject
	private UsuarioDao dao;

	private List<Usuario> todos;
	
	public List<Usuario> getTodos() {
		if (todos == null) {
			todos = dao.todos();
		}
		return todos;
	}
	
}
