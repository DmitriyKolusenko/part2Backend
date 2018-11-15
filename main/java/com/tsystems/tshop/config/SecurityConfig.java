package com.tsystems.tshop.config;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity(debug = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailServiceImp userDetailsService;

 	@Override
 	public void configure(WebSecurity web) throws Exception {
 		web.ignoring()
 		// Spring Security should completely ignore URLs starting with /resources/
 				.antMatchers("/resources/**")

		;
 	}

 	@Override
 	protected void configure(HttpSecurity http) throws Exception {
 		http.httpBasic()

				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
				.and().cors()
			//	.and().headers()
				.and().authorizeRequests()
				.anyRequest().hasAnyRole("USER","MANAGER").anyRequest().authenticated()
				.and().formLogin()/*.loginPage("/index.jsp")*/.loginProcessingUrl("/loginAction").permitAll().successForwardUrl("/api/token")
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/logout1").permitAll()
				.and().csrf().disable();
 	}

 	@Override
 	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 		auth.userDetailsService(userDetailsService)
				.passwordEncoder(NoOpPasswordEncoder.getInstance());
 	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		//configuration.addAllowedHeader("content-type");
		configuration.addAllowedHeader("x-auth-token");
		configuration.addAllowedHeader("x-requested-with");
		configuration.addAllowedHeader("x-xsrf-token");
		configuration.addAllowedOrigin("*");
		configuration.setMaxAge((long)3600);
		configuration.addAllowedMethod(HttpMethod.POST);
		configuration.addAllowedMethod(HttpMethod.GET);
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Bean
	HeaderHttpSessionStrategy sessionStrategy()
	{
		return new HeaderHttpSessionStrategy();
	}


}
