package com.CakeShop.OrderSystem.Security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

//     Configuring JDBC-based user details manager
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // Define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "SELECT username, password, enabled FROM users WHERE username=?");

        // Define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT username, authority FROM authorities WHERE username=?");

        return jdbcUserDetailsManager;

    }
//
////	@Bean
////    public UserDetailsManager userDetailsManager(DataSource dataSource) {
////        JdbcUserDetailsManager theUserDetailsManager = new JdbcUserDetailsManager(dataSource);
////        theUserDetailsManager.setUsersByUsernameQuery("select username, password, enabled from users where username=?");
////        theUserDetailsManager.setAuthoritiesByUsernameQuery("select username, authority from authorities where username=?");
////        return theUserDetailsManager;
////    }
//
////	 @Bean
////	    public PasswordEncoder passwordEncoder() {
////	        return new BCryptPasswordEncoder();
////	    }
//    // Configuring security filter chain
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                      .requestMatchers(HttpMethod.GET, "/Cake").hasAnyRole("CUSTOMER", "ADMIN")
                      .requestMatchers(HttpMethod.GET, "/Cake/{id}").hasAnyRole("CUSTOMER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/Cake").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/Cake").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/Cake/**").hasRole("ADMIN")
                        
                        .requestMatchers(HttpMethod.GET, "/Order/**").hasAnyRole("CUSTOMER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/Order").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.PUT, "/Order").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.DELETE, "/Order/**").hasRole("CUSTOMER")
                        
                        .requestMatchers(HttpMethod.GET, "/Admin/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/Admin").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/Admin").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/Admin/**").hasRole("ADMIN")
                        
                        .requestMatchers(HttpMethod.GET, "/Customer/**").hasAnyRole("CUSTOMER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/Customer").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.PUT, "/Customer/**").hasRole("CUSTOMER")
                        .requestMatchers(HttpMethod.DELETE, "/Customer/**").hasAnyRole("CUSTOMER", "ADMIN")
                        
                        
        );
        
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}