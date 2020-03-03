package ir.karafarinbank.config.security;

import ir.karafarinbank.model.Matcher;
import ir.karafarinbank.service.MatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private MatcherService matcherService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    };

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        List<Matcher> matchers = matcherService.loadMatcherByPageName();

        http.authorizeRequests().antMatchers("/").hasAnyRole();
        for (Matcher matcher : matchers) {

            http.authorizeRequests().antMatchers(matcher.getPageName()).hasAnyRole((matcher.getRole().replaceAll("ROLE_","")).split(","));

        }
        http.authorizeRequests().anyRequest().authenticated()
                    .and().formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/authenticateUser")
                .permitAll()
                .and().exceptionHandling().accessDeniedPage("/access-denied")
                .and().logout().permitAll();

    }

}
