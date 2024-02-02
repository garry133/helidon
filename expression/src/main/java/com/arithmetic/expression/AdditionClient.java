package com.arithmetic.expression;

import javax.ws.rs.POST;

import javax.ws.rs.Path;
@Path("/addition")
public interface AdditionClient {
    @POST
    public Addition execute(Addition request);
}
