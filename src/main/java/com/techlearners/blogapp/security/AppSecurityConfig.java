////package com.techlearners.blogapp.security;
////
////
////import org.springframework.boot.autoconfigure.SpringBootApplication;
////import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
////import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.http.HttpMethod;
////import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
////import org.springframework.security.web.SecurityFilterChain;
////
////@Configuration
//////@EnableWebSecurity
//////@ConditionalOnClass
//////@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
////public class AppSecurityConfig  {
////
////
////    @Bean
////    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
////
////        http.cors().and().csrf().disable()
////                .authorizeRequests()
////                .antMatchers(HttpMethod.POST, "/users", "/users/login").permitAll()
////                .anyRequest().authenticated();
////        return http.build();
////
////    }
//////    @Override
//////    protected void configure(HttpSecurity http) throws Exception {
//////        http.cors().and().csrf().disable()
//////                .authorizeRequests()
//////                        .antMatchers(HttpMethod.POST, "/users", "/users/login").permitAll()
//////                        .anyRequest().authenticated();
//////
//////
//////
////////        super.configure(http);
//////    }
////}
//
//
//package com.techlearners.blogapp.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable()
//                .authorizeRequests()
//                    .antMatchers(HttpMethod.POST, "/users", "/users/login").permitAll()
//                .anyRequest().authenticated();
//
//        super.configure(http);
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http.build();
//    }
//}
//







