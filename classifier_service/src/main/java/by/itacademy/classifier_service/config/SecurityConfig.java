package by.itacademy.classifier_service.config;

import by.itacademy.classifier_service.controllers.filter.JwtFilter;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String URL_COUNTRY = "/api/v1/classifier/country";
    private static final String URL_CONCERT = "/api/v1/classifier/concert/category";
    private static final String CHECK_CATEGORY_FOR_CLASSIFIER_CLIENT = "/api/v1/classifier/concert/check/**";
    private static final String CHECK_COUNTRY_FOR_CLASSIFIER_CLIENT = "/api/v1/classifier/country/check/**";
    private static final String ADMIN = "ADMIN";

    private final JwtFilter filter;
    //private final DaoAuthenticationProvider provider;

    public SecurityConfig(JwtFilter filter) {
        this.filter = filter;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Enable CORS and disable CSRF
        http = http.cors().and().csrf().disable();

        // Set session management to stateless
        http = http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();

        // Set unauthorized requests exception handler
        http = http
                .exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, ex) -> {
                            response.sendError(
                                    HttpServletResponse.SC_UNAUTHORIZED,
                                    ex.getMessage()
                            );
                        }
                )
                .and();

        // Set permissions on endpoints
        http.authorizeRequests()
                // Our public endpoints
                .antMatchers(HttpMethod.GET,CHECK_COUNTRY_FOR_CLASSIFIER_CLIENT).permitAll()
                .antMatchers(HttpMethod.GET,CHECK_CATEGORY_FOR_CLASSIFIER_CLIENT).permitAll()
                .antMatchers(HttpMethod.POST,URL_COUNTRY).hasAuthority(ADMIN)
                .antMatchers(HttpMethod.GET,URL_COUNTRY).permitAll()
                .antMatchers(HttpMethod.POST,URL_CONCERT).hasAuthority(ADMIN)
                .antMatchers(HttpMethod.GET,URL_CONCERT).permitAll()
                .anyRequest().authenticated();

        // Add JWT token filter
        http.addFilterBefore(
                filter,
                UsernamePasswordAuthenticationFilter.class
        );
    }
}