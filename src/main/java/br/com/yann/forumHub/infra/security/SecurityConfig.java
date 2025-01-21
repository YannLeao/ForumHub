package br.com.yann.forumHub.infra.security;

import br.com.yann.forumHub.infra.filter.SecurityFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final SecurityFilter securityFilter;

    public SecurityConfig(final SecurityFilter securityFilter) {
        this.securityFilter = securityFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize.requestMatchers(HttpMethod.POST, "/login").permitAll())
                .authorizeHttpRequests(authorize -> authorize.requestMatchers(HttpMethod.POST, "/usuarios").permitAll())
                .authorizeHttpRequests(authorize -> authorize.requestMatchers(HttpMethod.GET, "/usuarios/**").permitAll())
                .authorizeHttpRequests(authorize -> authorize.requestMatchers("/perfis/**").hasRole("ADMIN"))
                .authorizeHttpRequests(authorize -> authorize.requestMatchers(HttpMethod.POST, "/cursos/**").hasRole("ADMIN"))
                .authorizeHttpRequests(authorize -> authorize.requestMatchers(HttpMethod.PUT, "/cursos/**").hasRole("ADMIN"))
                .authorizeHttpRequests(authorize -> authorize.requestMatchers(HttpMethod.DELETE, "/cursos/**").hasRole("ADMIN"))
                .authorizeHttpRequests(authorize -> authorize.requestMatchers(HttpMethod.GET, "/cursos/**").hasRole("USER"))
                .authorizeHttpRequests(authorize -> authorize.requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll())
                .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
