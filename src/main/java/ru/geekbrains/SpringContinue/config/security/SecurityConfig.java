package ru.geekbrains.SpringContinue.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/addPerson").hasRole("SUPERADMIN")
                .antMatchers("/person").hasAnyRole("ADMIN", "SUPERADMIN")
                .antMatchers("/**").hasAnyRole("ADMIN", "MANAGER", "SUPERADMIN")
                .and()
                .formLogin().loginPage("/login").loginProcessingUrl("/authenticateTheUser").permitAll();
    }
}
