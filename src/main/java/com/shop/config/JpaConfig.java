package com.shop.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.shop.domain", "com.shop.model"})
@EnableJpaRepositories(basePackages = "com.shop.service")
@EnableTransactionManagement
public class JpaConfig  implements EnvironmentAware {

	@Value("${spring.datasource.driverClassName}")
	private String databaseDriverClassName;

	@Value("${spring.datasource.url}")
	private String datasourceUrl;

	@Value("${spring.datasource.username}")
	private String databaseUsername;

	@Value("${spring.datasource.password}")
	private String databasePassword;

	@Value("${spring.jpa.database-platform}")
	private String hibernateDialect;
	
	private RelaxedPropertyResolver environment;
	
	@Override
    public void setEnvironment(Environment environment) {
            this.environment = new RelaxedPropertyResolver(environment, "spring.jpa");
    }
	  
	@Bean
	public DataSource datasource() {
		org.apache.tomcat.jdbc.pool.DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
		ds.setDriverClassName(databaseDriverClassName);
		ds.setUrl(datasourceUrl);
		ds.setUsername(databaseUsername);
		ds.setPassword(databasePassword);

		return ds;
	}
	/*
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(datasource());
		factory.getHibernateProperties().setProperty("hibernate.dialect", hibernateDialect);
		return factory;
	}
	
	@Bean
	public JpaVendorAdapter hibernateJpaVendorAdapter(){
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		return adapter;
	}

    @Bean(name="entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean configureEntityManagerFactory(DataSource ds, JpaVendorAdapter adapter) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setPersistenceUnitName("myshopnshare-persistence-unit");
        entityManagerFactoryBean.setJpaVendorAdapter(adapter);
        entityManagerFactoryBean.setDataSource(ds);
        entityManagerFactoryBean.setPackagesToScan("com.shop.domain", "com.shop.model");
        entityManagerFactoryBean.getJpaPropertyMap().putAll(this.environment.getSubProperties("properties."));
        Map<String, Object> properties = entityManagerFactoryBean.getJpaPropertyMap();
        properties.put("hibernate.ejb.naming_strategy", this.environment.getProperty("hibernate.naming-strategy", SpringNamingStrategy.class.getName()));
        //properties.put("hibernate.hbm2ddl.auto", this.environment.getProperty("hibernate.ddl-auto", "none"));
        return entityManagerFactoryBean;
  
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
      JpaTransactionManager tm = new JpaTransactionManager();
      tm.setEntityManagerFactory(emf);
      return tm;
    }
	*/
}
