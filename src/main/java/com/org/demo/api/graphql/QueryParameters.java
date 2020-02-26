package com.org.demo.api.graphql;

import com.org.demo.api.utils.JsonKit;
import lombok.Getter;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Getter
public class QueryParameters {

    String query;
    String operationName;
    Map<String, Object> variables = Collections.emptyMap();

    public static QueryParameters from(HttpServletRequest request) {
        QueryParameters parameters = new QueryParameters();
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            Map<String, Object> json = readJSON(request);
            parameters.query = (String) json.get("query");
            parameters.operationName = (String) json.get("operationName");
            parameters.variables = getVariables(json.get("variables"));
        } else {
            parameters.query = request.getParameter("query");
            parameters.operationName = request.getParameter("operationName");
            parameters.variables = getVariables(request.getParameter("variables"));
        }
        return parameters;
    }

    private static Map<String, Object> getVariables(Object variables) {
        if (variables instanceof Map) {
            Map<?, ?> inputVars = (Map) variables;
            Map<String, Object> vars = new HashMap<>();
            inputVars.forEach((k, v) -> vars.put(String.valueOf(k), v));
            return vars;
        }
        return JsonKit.toMap(String.valueOf(variables));
    }

    private static Map<String, Object> readJSON(HttpServletRequest request) {
        String body = readPostBody(request);
        return JsonKit.toMap(body);
    }

    private static String readPostBody(HttpServletRequest request) {
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader reader = getReader(request);
            int counter;
            while ((counter = reader.read()) != -1) {
                sb.append((char) counter);
            }
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static BufferedReader getReader(HttpServletRequest request) throws IOException {

        return new BufferedReader(new InputStreamReader(request.getInputStream(),
            StandardCharsets.UTF_8));
    }

}