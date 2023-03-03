package com.yummyBites.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.ViewResolver;
// import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.yummyBites.security.JwtAuthenticationEntryPoint;
import com.yummyBites.security.JwtAuthenticationFilter;
import com.yummyBites.services.UserDetailsServiceImpl;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
@EnableWebMvc
public class SecurityConfig {

	public static final String[] public_URLS = { "/swagger-resources/**", "/swagger-ui/**", "/v3/api-docs",
			"/webjars/**", "/v2/api-docs**","/",
			"/signup", "/generate-token", "/forgot-password", "/verify-otp", "/change-password", "/v3/api-docs/**" };

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;

	@Bean
	UserDetailsService getUserDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	 ViewResolver internalResourceViewResolver() {
	    InternalResourceViewResolver bean = new InternalResourceViewResolver();
	    bean.setViewClass(JstlView.class);
	    bean.setPrefix("/webApp/view/");
	    bean.setSuffix(".jsp");
	    return bean;
	}

	// @Bean
	// UserDetailsService getUserDetailsService() {
	// UserDetails customer_user=User.withUsername("piyush")
	// .password(passwordEncoder().encode("Piyush")).roles("CUSTOMER").build();
	// InMemoryUserDetailsManager inMemoryUserDetailsManager= new
	// InMemoryUserDetailsManager(customer_user);
	// return inMemoryUserDetailsManager;
	// }
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}

	@Bean
	 AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
				.authorizeHttpRequests()
				 .requestMatchers("/home").permitAll()
				.requestMatchers("/customer").hasRole("CUSTOMER")
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.requestMatchers(public_URLS).permitAll()
				.anyRequest().authenticated()
				.and()
				.exceptionHandling().authenticationEntryPoint(this.jwtAuthenticationEntryPoint).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

		return httpSecurity.build();
	}
}
