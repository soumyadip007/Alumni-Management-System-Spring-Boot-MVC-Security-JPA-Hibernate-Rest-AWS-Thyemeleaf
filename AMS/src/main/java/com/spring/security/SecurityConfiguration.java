package com.spring.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource securityDataSource;
	
	@Autowired
	private CustomAuthenticationSuccessHandler successHandler;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// use jdbc authentication ... oh yeah!!!
		  auth.jdbcAuthentication().dataSource(securityDataSource)
		  .usersByUsernameQuery(
		   "select username,password,enabled from admin where username=?")
		  .authoritiesByUsernameQuery(
		   "select username, authority from admin where username=?")
		  .passwordEncoder(passwordEncoder()) ;
		 } 
	
	@Bean
	public PasswordEncoder passwordEncoder(){
	    return new PasswordEnconderTest();
	}




	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		//	.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/user/**").permitAll()
			.antMatchers("/restaurant/**").permitAll()
			.antMatchers("/area/**").permitAll()
			.antMatchers("/login/**").permitAll()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/ams/**").permitAll()
			.antMatchers("/js/**").permitAll()
			.antMatchers("/static/**").permitAll()
			.antMatchers("/vendor/**").permitAll()
			.antMatchers("/resources/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.csrf().disable()
			.formLogin()
			.loginPage("/adminlogin")
			.loginProcessingUrl("/authenticateTheUser")
			//.defaultSuccessUrl("/register")
			.permitAll()
		//	.successHandler(successHandler)
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/pp");
		 
	}


	
	@Override
	public void configure(WebSecurity web) throws Exception {
	
		web.ignoring().antMatchers("/resources/**","/login/**","/static/**","/Script/**","/Style/**","/Icon/**",
				"/js/**","/vendor/**","/bootstrap/**","/Image/**","/cvdetails/**","/ams/**");
		
		//logoutSuccessUrl("/customLogout")
	}
	

	@Bean
	public UserDetailsManager userDetailsManager() {
		
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
		
		jdbcUserDetailsManager.setDataSource(securityDataSource);
		
		return jdbcUserDetailsManager; 
	}
		
	
	
}

class PasswordEnconderTest implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return charSequence.toString().equals(s);
    }
}
