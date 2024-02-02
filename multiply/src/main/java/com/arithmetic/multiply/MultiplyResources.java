package com.arithmetic.multiply;

        import javax.inject.Inject;
        import javax.ws.rs.Consumes;
        import javax.ws.rs.POST;
        import javax.ws.rs.Path;
        import javax.ws.rs.Produces;
        import javax.ws.rs.core.MediaType;

@Path("/multiply")
public class MultiplyResources {
    @Inject
    private MultiplyBLogic blogic;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Multiply processMultiplication(Multiply request) {
        Multiply response = new Multiply();
        response.setNum1(request.getNum1());
        response.setNum2(request.getNum2());
        response.setResult(blogic.execute(request.getNum1(), request.getNum2()));
        return response;
    }
}
