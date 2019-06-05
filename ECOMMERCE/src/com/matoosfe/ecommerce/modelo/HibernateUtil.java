/**
 * 
 */
package com.matoosfe.ecommerce.modelo;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Clase Utilitaria para establecer la conexión con la bdd a través de Hibernate (hibernate.cfg.xml)
 * @author martosfre
 *
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory buildSesionFactory() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml -apply src directory
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
		return sessionFactory;
	}
}
