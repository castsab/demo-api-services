package com.org.demo.api.graphql;

import com.coxautodev.graphql.tools.SchemaParser;
import com.org.demo.api.resolver.UserResolver;
import graphql.servlet.SimpleGraphQLServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class GraphQLEndpoint {

    @Autowired
    private CustomGraphErrorHandler customGraphErrorHandler;

    @Autowired
    private UserResolver userResolver;
    
    @Bean
    ServletRegistrationBean graphQLServletRegistrationBean() {
        System.out.println("com.un.cif.api.graphql.GraphQLEndpoint.graphQLServletRegistrationBean()");
        return new ServletRegistrationBean(new SimpleGraphQLServlet(SchemaParser.newParser()
                .files("graphql/api.graphqls", "graphql/types.graphqls", "graphql/inputs.graphqls")
                .resolvers(
                    userResolver
                )
                .build()
                .makeExecutableSchema(),
                null,
                null,
                null,
                null,
                customGraphErrorHandler,
                null,
                null),
                "/api");
    }

}
