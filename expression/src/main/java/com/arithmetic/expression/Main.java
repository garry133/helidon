package com.arithmetic.expression;

import java.io.IOException;

import io.helidon.config.Config;
import io.helidon.config.ConfigSources;
import io.helidon.microprofile.server.Server;

public class Main {
    private Main() { }
    public static void main(final String[] args) throws IOException {
        Server server = startServer();
        System.out.println("http://localhost:" + server.port() + "/expression");
    }
    static Server startServer() {
        return Server.builder()
                .config(buildConfig())
                .build()
                .start();
    }
    private static Config buildConfig() {
        return Config.builder()
                .sources(
                        ConfigSources.classpath("META-INF/microprofile-config.properties"),
                        ConfigSources.classpath("META-INF/expression.properties")
                )
                .build();
    }
}
