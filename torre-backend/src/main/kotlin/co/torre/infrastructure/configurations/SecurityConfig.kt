package co.torre.infrastructure.configurations

import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.CorsRegistry
import org.springframework.web.reactive.config.WebFluxConfigurer

@Configuration
class CorsGlobalConfiguration : WebFluxConfigurer {
    override fun addCorsMappings(corsRegistry: CorsRegistry) {
        corsRegistry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("POST", "PUT", "GET", "PATCH", "DELETE")
            .allowedHeaders("Authorization", "Cache-Control", "Content-Type", "X-Frame-Options")
            .allowCredentials(false)
            .maxAge(3600)
    }
}