package br.com.caelum.blog.util.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Named
@ApplicationScoped
public class JPAUtil {
	
	@PersistenceUnit(unitName = "app")
	private EntityManagerFactory appFactory;
	
	@PersistenceUnit(unitName = "corporativo")
	private EntityManagerFactory corporativoFactory;
	
	@Produces
	@RequestScoped
	@Default
	public EntityManager getAppEntityManager() {
		return appFactory.createEntityManager();
	}
	
	@Produces
	@RequestScoped
	@Corporativo
	public EntityManager getCorporativoEntityManager() {
		return corporativoFactory.createEntityManager();
	}
	
	public void close(@Disposes @Any EntityManager em) {
		em.close();
	}
	
}
