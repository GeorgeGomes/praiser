package com.seismaismais.praiser.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {	  
		  http.authorizeRequests()
		  	.antMatchers("/static/**").permitAll()
		  	.antMatchers("/", "/home").permitAll()
		  	.antMatchers("/rest/auth/user/create").permitAll()
		  	.antMatchers("/auth").permitAll()
//		  	.antMatchers("/explore").authenticated()
		  	.and()
	      .formLogin()
	          .loginPage( "/login" )
	          .permitAll()
	      .and()
	      	.exceptionHandling().accessDeniedPage( "/403" )
	      .and()
	      	.httpBasic()
	      .and()
	      	.csrf().disable();
	}
}
