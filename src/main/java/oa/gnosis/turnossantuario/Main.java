/*
 *  Turnos Santuario
 *  Asignador de turnos para estudiantes.
 *  Este programa fue dise?ado para la Santa Iglesia Gnostica Universal, por Nestor Arias -nestor_arias@hotmail.com
 */
package oa.gnosis.turnossantuario;

import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import oa.gnosis.turnossantuario.spring.repositories.PersonaRepository;
import oa.gnosis.turnossantuario.ui.CRUDPersona;
import org.apache.derby.jdbc.EmbeddedDriver;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author nesto
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("oa.gnosis.turnossantuario.spring.repositories")
@ComponentScan(basePackages = "oa.gnosis.turnossantuario.spring.components")
public class Main {
    private ResourceBundle bundle = ResourceBundle.getBundle("application");
    private static PersonaRepository personaRepository = null;
    public static void main(String args[]) {
        //Registro de Spring
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(Main.class);
        ctx.refresh();
        personaRepository = ctx.getBean(PersonaRepository.class);
        //Inicio de swing
        CRUDPersona cp = new CRUDPersona();
        cp.setVisible(true);
        try {
            cp.wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        final DriverManagerDataSource resp = new DriverManagerDataSource();
        //TODO: pasar a archivo texto.
        resp.setDriverClassName(EmbeddedDriver.class.getName());
        resp.setUrl(bundle.getString("datasource.jdbc"));
        resp.setUsername(bundle.getString("datasource.username"));
        resp.setPassword(bundle.getString("datasource.password"));
        return resp;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[]{"oa.gnosis.turnossantuario.spring.model"});

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        final Properties properties = new Properties();
        for(String prop:new String[]
        {"hibernate.dialect","hibernate.hbm2ddl.auto","hibernate.show_sql","hibernate.format_sql"}){
            properties.put(prop, bundle.getString(prop));
        }
        em.setJpaProperties(properties);

        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
    
    public static PersonaRepository getPersonaRepository(){
        return personaRepository;
    }
}
