package pl.gambeat007.ucl.config;

import org.springframework.context.annotation.*;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/*
SwaggerUI url:
http://localhost:8080/swagger-ui/index.html
 */

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors. regex("^(?!/(error).*$).*$" ))
                .build();
    }
}
