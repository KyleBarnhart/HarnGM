package ca.barnhart.harngm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.metamodel.ManagedType;
import javax.persistence.metamodel.Metamodel;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public RepositoryConfig(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        Metamodel metamodel = entityManagerFactory.getMetamodel();

        // Spring data does expose IDs by default for some reason.
        // This will make id show for all entities.
        for (ManagedType<?> managedType : metamodel.getManagedTypes()) {
            Class<?> javaType = managedType.getJavaType();

            if (javaType.isAnnotationPresent(Entity.class)) {
                config.exposeIdsFor(managedType.getJavaType());
            }
        }
    }
}
