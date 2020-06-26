package com.motorcycleschool.school.security;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootProperties;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

//@Configuration
//@Component
//@CrossOrigin
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {

@KeycloakConfiguration
class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

    /**
     * Registers the KeycloakAuthenticationProvider with the authentication manager.
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
        auth.authenticationProvider(keycloakAuthenticationProvider);
    }

    /**
     * Provide a session authentication strategy bean which should be of type
     * RegisterSessionAuthenticationStrategy for public or confidential applications
     * and NullAuthenticatedSessionStrategy for bearer-only applications.
     */
    @Bean
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    /**
     * Use properties in application.properties instead of keycloak.json
     */
    @Bean
    @Primary
    public KeycloakConfigResolver keycloakConfigResolver(KeycloakSpringBootProperties properties) {
        return new CustomKeycloakSpringBootConfigResolver(properties);
    }

    /**
     * Secure appropriate endpoints
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {


        super.configure(http);
        http.authorizeRequests()
                .antMatchers("/customers*")
                .hasRole("user")
                .anyRequest()
                .permitAll();

//
//        http.authorizeRequests()
//                .antMatchers("/**").authenticated()
//                .anyRequest().authenticated();
    }
}
//    @Autowired
//    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .passwordEncoder(passwordEncoder())
//                .usersByUsernameQuery("SELECT username, password, enabled FROM users where username=?")
//                .authoritiesByUsernameQuery("SELECT username, password, enabled FROM users where username=?");
//
////        auth.jdbcAuthentication().dataSource(dataSource)
////                .usersByUsernameQuery("SELECT instructorUsername, instructorPassword, enabled FROM instructors where instructorUsername=?")
////                .authoritiesByUsernameQuery("SELECT instructorUsername, instructorPassword, enabled FROM instructors where instructorUsername=?");
//
//    auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("admin")).roles("admin", "user");
//    }

//
        //konfig pod oauth i jwt

//        http.cors()
//                .and()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/user/info", "/api/foos/**")
//                .hasAuthority("SCOPE_read")
//                .antMatchers(HttpMethod.POST, "/api/foos")
//                .hasAuthority("SCOPE_write")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .oauth2ResourceServer()
//                .jwt();


//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/**").permitAll()
//                .antMatchers("/login", "user/add").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .rememberMe().rememberMeParameter("rememberMe").tokenValiditySeconds(24 * 60 * 60)
//                .tokenRepository(persistentTokenRepository())
//                .and()
//                .httpBasic();

//                .rememberMe().tokenValiditySeconds(24 * 60 * 60)
//                .tokenRepository(persistentTokenRepository())
//                .and()
//                .httpBasic();

//        http.logout().logoutSuccessUrl("/login?logout").deleteCookies("JSESSIONID");
//    }
//
//
//    @Bean
//    protected PersistentTokenRepository persistentTokenRepository() {
//        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
//        tokenRepository.setDataSource(dataSource);
//        return tokenRepository;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//        return encoder;
//    }

