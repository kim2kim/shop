package com.shop.config;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Relationship;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.core.TypeRepresentationStrategy;
import org.springframework.data.neo4j.rest.SpringRestGraphDatabase;
import org.springframework.data.neo4j.support.typerepresentation.NoopRelationshipTypeRepresentationStrategy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//tag::config[]
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.shop.neo4j.graphs"})
@EnableNeo4jRepositories(basePackages = "com.shop.neo4j.repositories")
public class MyNeo4jConfiguration extends Neo4jConfiguration {

	public static final String URL = System.getenv("NEO4J_URL") != null ? System
			.getenv("NEO4J_URL") : "http://localhost:7474/db/data/";

	public MyNeo4jConfiguration() {
		setBasePackage("com.shop.neo4j.graphs");
	}

	@Bean
	public GraphDatabaseService graphDatabaseService() {
		return new SpringRestGraphDatabase(URL);
	}

	@Override
	public TypeRepresentationStrategy<Relationship> relationshipTypeRepresentationStrategy()
			throws Exception {
		return new NoopRelationshipTypeRepresentationStrategy();
	}
}