package br.com.caelum.blog.dao;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.com.caelum.blog.entity.Usuario;
import br.com.caelum.blog.util.cdi.Corporativo;

@Named
@Dependent
public class UsuarioDao {

	@Inject
	@Corporativo //para injetar o EntityManager Corporativo(que acessa o BD do corporativo)
	private EntityManager em;

	public List<Usuario> todos() {
		return em.createQuery("SELECT u FROM Usuario u ORDER BY u.dataCadastro DESC", Usuario.class).getResultList();
	}

}
