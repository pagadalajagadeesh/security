package com.jagdi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.jagdi.services.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	private static final String[] AUTH_LIST = {"/v3/api-docs/**",
            "/swagger-ui/**",
            "/swagger-ui.html"};

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider());
	}

	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userService);
		provider.setPasswordEncoder(bCryptPasswordEncoder);
		return provider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http
//        .cors()
//        .and()
//        .authorizeRequests()
//        .antMatchers(AUTH_LIST).permitAll()
//        .anyRequest().authenticated()
//        .and()
//        .httpBasic();
		 http.csrf().disable().formLogin().and().authorizeRequests().anyRequest().permitAll();
	}

}
