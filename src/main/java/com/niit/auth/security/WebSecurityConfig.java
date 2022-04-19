package com.niit.auth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				//.antMatchers("/v1/admin/**").hasAnyAuthority("ADMIN").antMatchers("/v1/employee/**")
				//.hasAnyAuthority("EMPLOYEE", "ADMIN", "TEAM-LEAD").antMatchers("/v1/team-lead/**")
				//.hasAnyAuthority("TEAM-LEAD", "ADMIN").antMatchers("/h2-console/**/**").permitAll()
				.antMatchers(HttpMethod.GET, "/v1/**").permitAll()
				.antMatchers(HttpMethod.POST, "/v1/**").permitAll()
				.anyRequest().authenticated().and()
				//.addFilter(
				//		new JWTAuthenticationFilter(bCryptPasswordEncoder, userDetailsService, authenticationManager()))
				//.addFilter(new JWTAuthorizationFilter(authenticationManager()))
				// this disables session creation on Spring Security
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	}

	@Override
	public void configure(org.springframework.security.config.annotation.web.builders.WebSecurity web)
			throws Exception {
		web.ignoring().antMatchers("/v2/api-docs").antMatchers("/swagger-resources/**").antMatchers("/swagger-ui.html")
				.antMatchers("/configuration/**").antMatchers("/webjars/**").antMatchers("/public").antMatchers("/");
		super.configure(web);
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}

}