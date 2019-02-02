package ca.vapurrmaid.discretemathapplications.configuration;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration for WebMVC.
 *
 * @author vapurrmaid
 */
@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    Environment env;

    /**
     * Enables CORS at the specified origins.
     *
     * @param registry CORS registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        List<String> origins = new ArrayList();
        origins.add("https://discomath.github.io");
        origins.add("https://vapurrmaid.github.io");

        if (env.containsProperty("allowLocalhost")) {
            origins.add("http://localhost:8081");
        }

        registry.addMapping("/api/**")
                .allowedOrigins(origins.toArray(new String[0]));
    }

}
