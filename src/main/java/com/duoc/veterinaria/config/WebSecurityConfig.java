package com.duoc.veterinaria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Description;

@Configuration
@EnableWebSecurity

public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
            // Rutas PÚBLICAS
                .requestMatchers("/", "/home").permitAll()
                .requestMatchers("/**.css").permitAll()
                .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                // Rutas PRIVADAS por rol
                .requestMatchers("/pacientes/**").hasAnyRole("ADMIN", "VETERINARIO", "RECEPCIONISTA")
                .requestMatchers("/citas/**").hasAnyRole("ADMIN", "VETERINARIO", "RECEPCIONISTA")
                // Cualquier otra ruta requiere autenticación
                .anyRequest().authenticated()
            )
            .formLogin((form) -> form
                .loginPage("/login")
                .defaultSuccessUrl("/home", true)
                .permitAll()
            )
            .logout((logout) -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll()
        );

        return http.build();
    }

    /**
     * USUARIOS EN MEMORIA - 3 usuarios con roles distintos.
     */
    
    @Bean
    @Description("In memory Userdetails service registered since DB doesn't have user table ")
    public UserDetailsService users() {
        // Usuario 1: Administrador - acceso total
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin123"))
                .roles("ADMIN")
                .build();

        // Usuario 2: Veterinario - accede a pacientes y citas
        UserDetails veterinario = User.builder()
                .username("veterinario")
                .password(passwordEncoder().encode("vet123"))
                .roles("VETERINARIO")
                .build();

        // Usuario 3: Recepcionista - accede a citas y registro de pacientes
        UserDetails recepcionista = User.builder()
                .username("recepcionista")
                .password(passwordEncoder().encode("recep123"))
                .roles("RECEPCIONISTA")
                .build();

        return new InMemoryUserDetailsManager(admin, veterinario, recepcionista);
    }
    /**
     * Encoder BCrypt - hashea las contraseñas de forma segura.
     */    

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}