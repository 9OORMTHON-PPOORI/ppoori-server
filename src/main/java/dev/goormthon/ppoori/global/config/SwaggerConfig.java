package dev.goormthon.ppoori.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI ppooriAPI() {
        Info info = new Info()
                .title("뿌리 API 명세서")
                .description("뿌리 백엔드 API 명세서")
                .version("1.0");

        return new OpenAPI()
                .info(info);
    }
}
