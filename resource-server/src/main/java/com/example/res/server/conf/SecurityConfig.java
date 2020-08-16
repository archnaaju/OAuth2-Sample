package com.example.res.server.conf;


import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;


@Configuration
@EnableResourceServer
public class SecurityConfig extends ResourceServerConfigurerAdapter {
    @Override
    @Order(Ordered.HIGHEST_PRECEDENCE)
	public void configure(HttpSecurity http) throws Exception {
		http
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.csrf().disable()
	  	.authorizeRequests()
        .antMatchers(HttpMethod.PUT,"/api/v1/customers/**").authenticated()
		.antMatchers(HttpMethod.DELETE,"/api/v1/customers/**").authenticated()
		.antMatchers(HttpMethod.PUT,"/api/v1/products/**").authenticated()
		.antMatchers(HttpMethod.DELETE,"/api/v1/products/**").authenticated()
	  	.and()
	  	.httpBasic()
	  		.realmName("CRM_REALM");
    }


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        // do not require a resource id in AccessToken.
        resources.resourceId(null);
    }
}



