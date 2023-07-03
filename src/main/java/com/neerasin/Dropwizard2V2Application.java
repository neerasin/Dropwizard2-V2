package com.neerasin;

import com.neerasin.api.CalculatorService;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class Dropwizard2V2Application extends Application<Dropwizard2V2Configuration> {

    public static void main(final String[] args) throws Exception {
        new Dropwizard2V2Application().run(args);
    }

    @Override
    public String getName() {
        return "Dropwizard2V2";
    }

    @Override
    public void initialize(final Bootstrap<Dropwizard2V2Configuration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<Dropwizard2V2Configuration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(Dropwizard2V2Configuration configuration) {
                return configuration.swaggerBundleConfiguration;
            }
        });
    }

    @Override
    public void run(final Dropwizard2V2Configuration configuration,
                    final Environment environment) {
        CalculatorService calculatorService = new CalculatorService();
        environment.jersey().register(calculatorService);
    }

}
