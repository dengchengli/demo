package springcloud.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author: Dely
 * @Date: 2019/11/26 14:03
 */


/**
 * 自定义security配置
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/","/home").permitAll()
                    .anyRequest().authenticated()
                    .and()

                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()

                .logout()
                    .permitAll();

    }

    /**
     *在内存中配置一个用户及其密码和权限
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("admin").password("{noop}admin").roles("USER");
    }
}
