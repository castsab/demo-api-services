package com.org.demo.api.graphql;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Log4j
public class CustomGraphErrorHandler implements GraphQLErrorHandler {

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> errors) {
        List<GraphQLError> clientErrors = errors.stream()
            .filter(this::isClientError)
            .collect(Collectors.toList());

        List<GraphQLError> serverErrors = errors.stream()
            .filter(e -> !isClientError(e))
            .map(GraphQLErrorAdapter::new)
            .collect(Collectors.toList());

        List<GraphQLError> graphQLErrors = new ArrayList<>();
        graphQLErrors.addAll(clientErrors);
        graphQLErrors.addAll(serverErrors);
        return graphQLErrors;
    }

    protected List<GraphQLError> filterGraphQLErrors(List<GraphQLError> errors) {
        return errors.stream()
            .filter(this::isClientError)
            .collect(Collectors.toList());
    }

    protected boolean isClientError(GraphQLError error) {
        return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
    }

}
