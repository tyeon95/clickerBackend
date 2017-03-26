package io.muic.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tyeon on 16-Mar-17.
 */
@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(WebApplication.class, args);

        ApplicationInitializer applicationInitializer = ctx.getBean(ApplicationInitializer.class);
        applicationInitializer.populateDatabase();
    }
}
