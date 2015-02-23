package com.shop.test.context;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean;

@Configuration
public class TestContext {
	

	@Bean(name = "dbUnitDatabaseConnection")
	public DatabaseDataSourceConnectionFactoryBean dbunitDatabaseConnection(DataSource datasource){
		DatabaseDataSourceConnectionFactoryBean dbUnitDBConnection = new DatabaseDataSourceConnectionFactoryBean();
		dbUnitDBConnection.setDataSource(datasource);
		dbUnitDBConnection.setSchema("testshop");
		return dbUnitDBConnection;
	}
		
	/*
    <bean id="dbUnitDatabaseConfig" class="com.github.springtestdbunit.bean.DatabaseConfigBean">
    <property name="datatypeFactory">
        <bean class="org.dbunit.ext.postgresql.PostgresqlDataTypeFactory" />
    </property>
    <!--property name="qualifiedTableNames" value="true" /-->
    <property name="caseSensitiveTableNames" value="true" />
</bean>

<bean id="dbUnitDatabaseConnection" class="com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean">
    <property name="dataSource" ref="dataSource" />
    <property name="databaseConfig" ref="dbUnitDatabaseConfig"/>
    <property name="schema" value="sapeo"/>
</bean>
*/
}
