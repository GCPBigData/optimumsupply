package br.caed.config;

import br.caed.service.UserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        //@formatter:off
        return http
            .csrf().disable()
            .authorizeExchange()
                .pathMatchers(HttpMethod.PUT, "/pessoas/v1/**").hasRole("ADMIN")
                .pathMatchers(HttpMethod.DELETE, "/pessoas/v1/**").hasRole("ADMIN")
                .pathMatchers(HttpMethod.GET, "/pessoas/v1/**").hasRole("USER")
                .pathMatchers(HttpMethod.GET, "/pessoas/v1/buscaPorNome/**").hasRole("USER")
                .pathMatchers(HttpMethod.POST, "/pessoas/v1/salvar/**").hasRole("USER")
                .pathMatchers(HttpMethod.POST, "/pessoas/v1/**").hasRole("USER")
                .pathMatchers("/swagger-ui.html",
                    "/swagger-ui/**",
                    "/v3/api-docs/**",
                    "/webjars/**")
            .permitAll()
            .anyExchange().authenticated()
            .and()
                .formLogin()
            .and()
                .httpBasic()
            .and()
                .build();
        //@formatter:on
    }

    @Bean
    ReactiveAuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
        return new UserDetailsRepositoryReactiveAuthenticationManager(userDetailsService);
    }
}
