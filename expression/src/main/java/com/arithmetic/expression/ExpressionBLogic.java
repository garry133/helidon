package com.arithmetic.expression;

import java.net.URI;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.RestClientBuilder;

@ApplicationScoped
public class ExpressionBLogic {
    @Inject
    ExpressionConfig config;
    public int processExpression(int num1, int num2, int num3) throws Exception{
        //Invoke Addition Service
//        URI addURI = new URI("http://localhost:8080");
        URI addURI = new URI(config.getAdditionUrl());
        AdditionClient addClient = RestClientBuilder.newBuilder()
                .baseUri(addURI)
                .build(AdditionClient.class);
        Addition addRequest = new Addition();
        addRequest.setNum1(num1);
        addRequest.setNum2(num2);
        Addition addResponse = addClient.execute(addRequest);
        //Invoke Multiply Service
//        URI multiplyURI = new URI("http://localhost:8081");
        URI multiplyURI = new URI(config.getMultiplyUrl());
        MultiplyClient multiplyClient = RestClientBuilder.newBuilder()
                .baseUri(multiplyURI)
                .build(MultiplyClient.class);
        Multiply multiplyRequest = new Multiply();
        multiplyRequest.setNum1(addResponse.getResult());
        multiplyRequest.setNum2(num3);
        Multiply multiplyResponse = multiplyClient.execute(multiplyRequest);
        //Return the final result.
        int exprResult = multiplyResponse.getResult();
        return exprResult;
    }
}
