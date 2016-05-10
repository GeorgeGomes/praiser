package com.seismaismais.praizer.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {	  
		  http.authorizeRequests()
		  	.antMatchers("/static/**").anonymous()
		  	.antMatchers("/", "/home").permitAll()
		  	.antMatchers("/explore").authenticated()
		  	//.anyRequest().authenticated()
		  	.and()
	      .formLogin()
	          .loginPage( "/login" )
	          .loginProcessingUrl( "/j_spring_security_check" )
	          .usernameParameter("email")
	          .passwordParameter("password")
	          .defaultSuccessUrl( "/" )
	          .failureUrl("/login?error=")
	          .permitAll()
	      .and()
	      	.logout()
	          .logoutUrl( "/j_spring_security_logout" )
	          .logoutSuccessUrl( "/" )
	          .invalidateHttpSession(true)
	      .and()
	      	.exceptionHandling().accessDeniedPage( "/403" )
	      .and()
	      	.httpBasic()
	      .and()
	      	.csrf().disable();
	  
	}
}
