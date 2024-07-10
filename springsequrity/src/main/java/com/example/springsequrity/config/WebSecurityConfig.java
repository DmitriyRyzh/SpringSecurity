package com.example.springsequrity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                /*.authorizeRequests((AutorizeRequests) -> AutorizeRequests
                        .anyRequest().fullyAuthenticated())
                .formLogin(formLogin -> formLogin.loginPage("/login").failureUrl("/login?error")
                                .permitAll())
                .logout(logout -> logout.logoutUrl("logout").deleteCookies("remember-me")
                        .logoutSuccessUrl("/")
                        .permitAll())
                .rememberMe(rememberMe -> rememberMe.key("remember-me")
                        .tokenValiditySeconds(86400));*/

                .authorizeHttpRequests((requests) -> requests
                       .requestMatchers()
                        .permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}
