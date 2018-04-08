package com.yindeyue.controller;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.ui.ModelMap;
import org.springframework.util.PathMatcher;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.util.UrlPathHelper;

import com.yindeyue.entity.MyInterceptor;
import com.yindeyue.entity.MyMessageConverter;

@Configuration
@EnableWebMvc
public class My extends WebMvcConfigurerAdapter {
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		converters.add(new MyMessageConverter());
		System.out.println(converters);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addRedirectViewController("/demoo", "/demo");
		registry.addViewController("/demo").setViewName("shiyan");
		registry.addStatusController("/status", HttpStatus.I_AM_A_TEAPOT);
		super.addViewControllers(registry);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/**").addResourceLocations("classpath:index.html");
		super.addResourceHandlers(registry);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/**");
		registry.addWebRequestInterceptor(new WebRequestInterceptor() {

			@Override
			public void preHandle(WebRequest request) throws Exception {
				// TODO Auto-generated method stub

			}

			@Override
			public void postHandle(WebRequest request, ModelMap model) throws Exception {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterCompletion(WebRequest request, Exception ex) throws Exception {
				// TODO Auto-generated method stub

			}
		});
		super.addInterceptors(registry);
	}

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		// TODO Auto-generated method stub
//		configurer.setUseRegisteredSuffixPatternMatch(registeredSuffixPatternMatch)
		 configurer.setUseSuffixPatternMatch(false);
		 configurer.setUseTrailingSlashMatch(false);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		PathMatcher pathMatcher = configurer.getPathMatcher();
		System.out.println(pathMatcher);
		UrlPathHelper urlPathHelper = configurer.getUrlPathHelper();
		System.out.println(urlPathHelper);
		System.out.println(configurer.isUseRegisteredSuffixPatternMatch());
		System.out.println(configurer.isUseSuffixPatternMatch());
		System.out.println(configurer.isUseTrailingSlashMatch());
		// configurer.setPathMatcher(pathMatcher)
		// configurer.setUrlPathHelper(urlPathHelper)
		// configurer.setUseRegisteredSuffixPatternMatch(registeredSuffixPatternMatch)
		// configurer.setUseSuffixPatternMatch(suffixPatternMatch)
		// configurer.setUseTrailingSlashMatch(trailingSlashMatch)
		super.configurePathMatch(configurer);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		// TODO Auto-generated method stub
		super.configureContentNegotiation(configurer);
	}

	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		// TODO Auto-generated method stub
		super.configureAsyncSupport(configurer);
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		super.configureDefaultServletHandling(configurer);
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		// TODO Auto-generated method stub
		super.addFormatters(registry);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		super.addCorsMappings(registry);
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		super.configureViewResolvers(registry);
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		// TODO Auto-generated method stub
		super.addArgumentResolvers(argumentResolvers);
	}

	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
		// TODO Auto-generated method stub
		super.addReturnValueHandlers(returnValueHandlers);
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		super.configureMessageConverters(converters);
	}

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		// TODO Auto-generated method stub
		super.configureHandlerExceptionResolvers(exceptionResolvers);
	}

	@Override
	public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		// TODO Auto-generated method stub
		super.extendHandlerExceptionResolvers(exceptionResolvers);
	}

	@Override
	public Validator getValidator() {
		// TODO Auto-generated method stub
		return super.getValidator();
	}

	@Override
	public MessageCodesResolver getMessageCodesResolver() {
		// TODO Auto-generated method stub
		return super.getMessageCodesResolver();
	}

}
