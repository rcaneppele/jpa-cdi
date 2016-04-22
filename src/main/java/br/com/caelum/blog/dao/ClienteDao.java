package br.com.caelum.blog.dao;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.caelum.blog.entity.Cliente;

@Named
@Dependent
public class ClienteDao {

	@Inject
	@Default //para injetar o EntityManager Default(que acessa o BD da app)
	private EntityManager em;

	public List<Cliente> todos() {
		return em.createQuery("SELECT c FROM Cliente c ORDER BY c.nome", Cliente.class).getResultList();
	}

}
