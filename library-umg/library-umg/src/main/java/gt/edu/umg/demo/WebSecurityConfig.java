package gt.edu.umg.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import gt.edu.umg.demo.jwt.JwtAuthEntryPoint;
import gt.edu.umg.demo.jwt.JwtAuthTokenFilter;
import gt.edu.umg.demo.utils.TcUserDetailsService;


@Configuration
// @EnableOAuth2Sso
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    TcUserDetailsService tcUserDetailsService;

    @Autowired
    private JwtAuthEntryPoint jwtAuthEntryPoint;

    @Bean
    public JwtAuthTokenFilter authenticationJwtTokenFilter () {
        return new JwtAuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(tcUserDetailsService)
        .passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
        .antMatchers(HttpMethod.GET, "/user/all").hasRole("ADMIN")

        // AUTHOR
        .antMatchers(HttpMethod.GET, 
            "/author/listar", "/author/busqueda/{dato}", "/author/ver/{id}")
        .permitAll()
        .antMatchers(HttpMethod.POST, "/author/crear").hasAnyRole("USER", "ADMIN")
        .antMatchers(HttpMethod.PUT, "/author/editar/{id}").hasAnyRole("USER", "ADMIN")
        .antMatchers(HttpMethod.DELETE, "/author/borrar/{id}").hasRole("ADMIN")
        
        // CATEGORY
        .antMatchers(HttpMethod.GET, "/category/listar", "/category/ver/{id}").permitAll()
        .antMatchers(HttpMethod.POST, "/category/crear").hasAnyRole("USER", "ADMIN")
        .antMatchers(HttpMethod.PUT, "/category/editar/{id}").hasAnyRole("USER", "ADMIN")
        .antMatchers(HttpMethod.DELETE, "/category/borrar/{id}").hasRole("ADMIN")

        // COUNTRY
        .antMatchers(HttpMethod.GET, "/country/listar", "/country/ver/{id}").permitAll()
        .antMatchers(HttpMethod.POST, "/country/crear").hasAnyRole("USER", "ADMIN")
        .antMatchers(HttpMethod.PUT, "/country/editar/{id}").hasAnyRole("USER", "ADMIN")
        .antMatchers(HttpMethod.DELETE, "/country/borrar/{id}").hasRole("ADMIN")

        // DOCUMENT
        .antMatchers(HttpMethod.GET, 
            "/document/listar", "/document/busqueda/{dato}", "/document/ver/{id}", 
            "/document/category/{id}","/document/author", "/document/category")
        .permitAll()
        .antMatchers(HttpMethod.POST, "/document/crear").hasAnyRole("USER", "ADMIN")
        .antMatchers(HttpMethod.PUT, "/document/editar/{id}").hasAnyRole("USER", "ADMIN")
        .antMatchers(HttpMethod.DELETE, "/document/borrar/{id}").hasRole("ADMIN")

        // EDITORIAL
        .antMatchers(HttpMethod.GET, "/editorial/listar", "/editorial/ver/{id}").permitAll()
        .antMatchers(HttpMethod.POST, "/editorial/crear").hasAnyRole("USER", "ADMIN")
        .antMatchers(HttpMethod.PUT, "/editorial/editar/{id}").hasAnyRole("USER", "ADMIN")
        .antMatchers(HttpMethod.DELETE, "/editorial/borrar/{id}").hasRole("ADMIN")

        // LENGUAJE
        .antMatchers(HttpMethod.GET, "/lenguaje/listar", "/lenguaje/ver/{id}").permitAll()
        .antMatchers(HttpMethod.POST, "/lenguaje/crear").hasAnyRole("USER", "ADMIN")
        .antMatchers(HttpMethod.PUT, "/lenguaje/editar/{id}").hasAnyRole("USER", "ADMIN")
        .antMatchers(HttpMethod.DELETE, "/lenguaje/borrar/{id}").hasRole("ADMIN")

        // ROLE
        .antMatchers(HttpMethod.GET, "/role/all", "/role/{roleId}").hasRole("ADMIN")
        .antMatchers(HttpMethod.POST, "/role/add").hasRole("ADMIN")
        .antMatchers(HttpMethod.PUT, "/role/{roleId}").hasRole("ADMIN")

        // USER
        .antMatchers(HttpMethod.GET, "/user/all", "/user/{userId}").hasRole("ADMIN")
        .antMatchers(HttpMethod.POST, "/user/add/google").hasRole("ADMIN")
        .antMatchers(HttpMethod.POST, "/user/add", "/user/login", "/user/login/google/{email}").permitAll()
        .antMatchers(HttpMethod.PUT, "/user/{userId}").hasRole("ADMIN")
        .anyRequest().authenticated()
        .and()
        .exceptionHandling().authenticationEntryPoint(jwtAuthEntryPoint)
        .and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}