package com.todolist.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.mvc.WebContentInterceptor;


@Configuration
@EnableWebMvcSecurity
@ComponentScan(basePackages = { "com.todolist" })
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Resource(name = "userDetailsService")
	private UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailsService);
		/*auth.inMemoryAuthentication().withUser("Lusername")
				.password("password")
				.authorities("ROLE_LEAD_PROGRAMMER", "ROLE_PROGRAMMER").and()
				.withUser("Gusername").password("password")
				.authorities("ROLE_GROUP_LEADER", "ROLE_PROGRAMMER").and()
				.withUser("Pusername").password("password")
				.authorities("ROLE_PROGRAMMER").and().withUser("hireme")
				.password("password").authorities("ROLE_GUEST");*/

	}
	

	@Autowired
	@Bean
	public WebContentInterceptor webContentInterceptor() {
		WebContentInterceptor webContentInterceptor = new WebContentInterceptor();
		webContentInterceptor.setCacheSeconds(0);
		return webContentInterceptor;
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/index.html").permitAll()
				.antMatchers("/addMember.html")
				.access("hasRole('ROLE_GROUP_LEADER')")
				.antMatchers("/resources/**").permitAll().and().csrf()
				.disable().formLogin().loginPage("/login.html")
				.usernameParameter("username")
				.passwordParameter("password").permitAll()
				.defaultSuccessUrl("/index.html").and().logout()
				.logoutUrl("/logout").logoutSuccessUrl("/index.html")
				.deleteCookies("JSESSIONID").invalidateHttpSession(true)
				.permitAll();
	}

}
