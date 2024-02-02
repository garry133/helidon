package com.arithmetic.expression;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class ExpressionConfig {
    private String additionUrl, multiplyUrl;
    @Inject
    public ExpressionConfig(@ConfigProperty(name="addition.url") String additionUrl,
                            @ConfigProperty(name="multiply.url") String multiplyUrl) {
        this.additionUrl = additionUrl;
        this.multiplyUrl = multiplyUrl;
    }
    public String getAdditionUrl() {
        return additionUrl;
    }
    public String getMultiplyUrl() {
        return multiplyUrl;
    }
}
