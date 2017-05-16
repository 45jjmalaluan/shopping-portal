package com.ethoca.sp.config;

import com.ethoca.sp.comm.target.CartRestClient;
import com.ethoca.sp.comm.target.ProductRestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * Configuration class for a web setup.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Resource
    private Environment env;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CartRestClient cartRestClient() {
        return new CartRestClient(env.getRequiredProperty("ess.api.cart.url"));
    }

    @Bean
    public ProductRestClient productRestClient() {
        return new ProductRestClient(env.getRequiredProperty("ess.api.product.url"));
    }
}
