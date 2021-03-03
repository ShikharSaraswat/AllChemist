//package com.app.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//	@EnableWebSecurity
//	public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	    @Override
//	    protected void configure(HttpSecurity http) throws Exception {
//	        http.authorizeRequests()
//	                .antMatchers("/web/admin/**").hasAnyRole(ADMIN.toString(), GUEST.toString())
//	                .anyRequest().permitAll()
//	                .and()
//	                .formLogin().loginPage("/patient/login").permitAll()
//	                .and()
//	                .csrf().ignoringAntMatchers("/contact-email")
//	                .and()
//	                .logout().logoutUrl("/web/logout").logoutSuccessUrl("/web/").permitAll();
//	    }
//
//	    @Autowired
//	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//	        auth.inMemoryAuthentication()
//	                .withUser("admin").password("admin").roles(ADMIN.toString())
//	                .and()
//	                .withUser("guest").password("guest").roles(GUEST.toString());
//	    }
//
//	}
//
