package com.seismaismais.praiser.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.seismaismais.praiser")
public class ServletConfiguration extends WebMvcConfigurerAdapter {

	// VIEW RESOLVER DEFAULT
	// @Bean(name="Praizer")
	// public ViewResolver viewResolver() {
	// InternalResourceViewResolver viewResolver = new
	// InternalResourceViewResolver();
	// viewResolver.setViewClass(JstlView.class);
	// viewResolver.setPrefix("/WEB-INF/views/");
	// viewResolver.setSuffix(".jsp");
	//
	// return viewResolver;
	// }

	@Bean(name = "Praiser")
	TilesViewResolver viewResolver() {
		TilesViewResolver viewResolver = new TilesViewResolver();
		return viewResolver;
	}

	/*
	 * Configure ResourceHandlers to serve static resources like CSS/ Javascript
	 * etc...
	 *
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions("WEB-INF/tile-defs/definitions.xml", "WEB-INF/tile-defs/templates.xml");
		tilesConfigurer
				.setPreparerFactoryClass(org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory.class);
		return tilesConfigurer;
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver resolver=new CommonsMultipartResolver();
	    resolver.setDefaultEncoding("utf-8");
	    return resolver;
	}

}