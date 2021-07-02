package com.db.tradestore.foundation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.db.tradestore.service.UserService;

@Configuration
@EnableWebSecurity
public class BasicAuthConfiguration extends WebSecurityConfigurerAdapter {

	private static final String[] AUTH_WHITELIST = { "/v2/api-docs", "/swagger-resources/configuration/ui",
			"/swagger-resources", "/swagger-resources/configuration/security", "/swagger-ui.html", "/webjars/**",
			"/h2-console/**", "/ping" };

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll().and().authorizeRequests().anyRequest()
				.authenticated().and().httpBasic().and().csrf().disable();
		http.headers().frameOptions().disable();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		String encodingId = "bcrypt";
		Map<String, PasswordEncoder> encoders = new HashMap<>();
		encoders.put(encodingId, new BCryptPasswordEncoder());
		return new DelegatingPasswordEncoder(encodingId, encoders);
	}

	@Bean
	public AuthenticationProvider daoAuthenticationProvider(UserService userService) {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(userService);
		return provider;
	}
}
