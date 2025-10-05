package com.satyam.Spring_Sec_Proj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
//this class will be used to change the default behaviour of spring security
//example we will use it to disable csrf-token and make it stateless
//when we want to change something we need tot return object of SecurityFilterChain
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;  //it's a interface

    @Bean
    public AuthenticationProvider authProivder(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        //this wont work alone, we need to tell about the db and classes
        //User table name , how we represnt the class

        provider.setUserDetailsService(userDetailsService);
        //not using any password encoder
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//        Customizer<CsrfConfigurer<HttpSecurity>> custCsrf = new Customizer<CsrfConfigurer<HttpSecurity>>() {
//            @Override
//            public void customize(CsrfConfigurer<HttpSecurity> httpSecurityCsrfConfigurer) {
//                httpSecurityCsrfConfigurer.disable();
//            }
//        };
//
//        http.csrf(custCsrf);
//
//        Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> custHttp = new Customizer<AuthorizeHttpRequestsConfigurer<org.springframework.security.config.annotation.web.builders.HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>() {
//            @Override
//            public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry registry) {
//                registry.anyRequest().authenticated();
//            }
//        }
//
//        http.authorizeHttpRequests(custHttp);


        //***********DOING WITH HELP OF LAMBDA METHODS************
        //disabling csrf
//        http.csrf(customizer -> customizer.disable());
//        //enabling auth for every request
//        http.authorizeHttpRequests(request->request.anyRequest().authenticated());
//
//        http.formLogin(Customizer.withDefaults());
//        http.httpBasic(Customizer.withDefaults());
//        //making stateless
//        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        //BUILDER PATTERN
        http
                .csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(customizer -> customizer.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }



//    @Bean
//    public UserDetailsService userDetailsService() {
//        //not actual way of doing as the users will be coming from db
//       //we can have multiple users here as well
//        UserDetails user = User
//                .withDefaultPasswordEncoder()
//                .username("satyam")
//                .password("111")
//                .roles("USER").build();
//        return new InMemoryUserDetailsManager(user);
//
//    }

}
