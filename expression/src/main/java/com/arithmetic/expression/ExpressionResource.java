package com.arithmetic.expression;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/expression")
public class ExpressionResource {
    @Inject
    ExpressionBLogic bLogic;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Expression processExpression(Expression request) throws Exception{
        Expression response = new Expression();
        response.setNum1(request.getNum1());
        response.setNum2(request.getNum2());
        response.setNum3(request.getNum3());

        int result = bLogic.processExpression(request.getNum1(), request.getNum2(), request.getNum3());
        response.setResult(result);
        return response;
    }
}
