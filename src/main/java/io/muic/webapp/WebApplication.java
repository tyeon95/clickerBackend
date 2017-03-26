package io.muic.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/users/leaderboards").allowedOrigins("http://localhost:8081").allowedMethods("GET", "POST").allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
//                        "Access-Control-Request-Headers")
//                        .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
////                registry.addMapping("/users/*").allowedOrigins("http://localhost:8081");
////                registry.addMapping("/users/leaderboards").allowedOrigins("http://localhost:8081");
//            }
//        };
//    }
}
