package br.com.caelum.blog.mb;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.blog.dao.ClienteDao;
import br.com.caelum.blog.entity.Cliente;

@Named
@RequestScoped
public class ClienteBean {
	
	@Inject
	private ClienteDao dao;

	private List<Cliente> todos;
	
	public List<Cliente> getTodos() {
		if (todos == null) {
			todos = dao.todos();
		}
		return todos;
	}
	
}
