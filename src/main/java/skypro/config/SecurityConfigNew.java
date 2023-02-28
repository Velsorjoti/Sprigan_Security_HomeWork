package skypro.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfigNew extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

    public SecurityConfigNew(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/").hasAnyRole("EMPLOYEE", "IT", "SECURITY", "DIRECTOR")
                .antMatchers("/it_info").hasAnyRole( "IT", "SECURITY", "DIRECTOR")
                .antMatchers("/security_info").hasAnyRole( "SECURITY", "DIRECTOR")
                .antMatchers("/director_info").hasAnyRole("DIRECTOR")
                .and().formLogin().permitAll();
    }
}
