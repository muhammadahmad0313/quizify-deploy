package team4.quizify.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors(withDefaults())  // Enable CORS
            .csrf(csrf -> csrf.disable())  // Disable CSRF protection for API endpoints
            .authorizeHttpRequests(authz -> authz
                .requestMatchers(new AntPathRequestMatcher("/Quizify/login")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/Quizify/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
            )
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .httpBasic(withDefaults());
            
        return http.build();
    }
}
