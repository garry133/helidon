package io.helidon.examples.quickstart.mp;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;


@Dependent
public class Initializer {
    @Produces
    @ApplicationScoped
    public EmployeeRepository initializeRepositiory() {
        return new EmployeeRepository();
    }

}
