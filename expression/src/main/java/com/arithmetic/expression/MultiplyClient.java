package com.arithmetic.expression;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/multiply")
public interface MultiplyClient {
    @POST
    public Multiply execute(Multiply request);
}
