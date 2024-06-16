package com.example.ecommercepi;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Permite CORS para todas as rotas
                .allowedOrigins("http://localhost:4200")  // Permite CORS apenas para esta origem
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Permite estes métodos HTTP
                .allowedHeaders("*")  // Permite todos os cabeçalhos
                .allowCredentials(true);  // Permite credenciais
    }
}
