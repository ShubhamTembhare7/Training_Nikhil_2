package com.yash.configuration;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.yash.logger.ProcessingTimeInterceptor;


@Configuration
public class SpringConfig extends WebMvcConfigurerAdapter{
	
	@Bean
public MessageSource messageSource()
{
	ResourceBundleMessageSource resource= new ResourceBundleMessageSource();
	resource.setBasename("message");
	return resource;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		
		registry.addResourceHandler("/img/**").addResourceLocations("/resources/images/");
	}
	
	@Bean
	public CommonsMultipartResolver fileResolver() {
		CommonsMultipartResolver resolver=new CommonsMultipartResolver();
		resolver.setDefaultEncoding("utf-8");
		return resolver;
	}

	@Bean("localeResolver")
    public LocaleResolver resolver() {
        SessionLocaleResolver resolver = new SessionLocaleResolver();
        resolver.setDefaultLocale(new Locale("en"));
        return resolver;
        
    }
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ProcessingTimeInterceptor());
		LocaleChangeInterceptor intercep=new LocaleChangeInterceptor();
		intercep.setParamName("langauge");
		registry.addInterceptor(intercep);
		
	}
	
}
