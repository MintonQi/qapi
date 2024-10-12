package com.minton.qapi.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootConfiguration
public class SwaggerConfig {

    /**
     * 文档首页概述
     *
     * @return
     */
    @Bean
    public OpenAPI globalOpenApi() {
        return new OpenAPI()
                .info(new Info().title("qapi系统")
                        .description("接口文档")
                        .version("3.0"));
    }


    // @Bean
    // OpenAPI openApiCustomiser() {
    //     System.out.println("openApiCustomiser ---------------------");
    //     return new OpenAPI().info(new io.swagger.v3.oas.models.info.Info()
    //                 .title("QAPI接口文档")
    //                 .description("QAPI项目的API文档")
    //                 .version("v1.0.0")
    //                 .contact(new io.swagger.v3.oas.models.info.Contact()
    //                         .name("Minton")
    //                         .email("minton@example.com")
    //                         .url("https://github.com/mintonqi")));
    //     };
    // }
}
