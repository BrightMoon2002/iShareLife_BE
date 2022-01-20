package com.example.isharelife.config.auth;

import com.example.isharelife.security.jwt.JwtEntryPoint;
import com.example.isharelife.security.jwt.JwtTokenFilter;
import com.example.isharelife.security.userprincipal.AccountDetailService;
import com.example.isharelife.security.userprincipal.AccountPrinciple;
import com.example.isharelife.service.impl.AccountServiceImpl;
import com.example.isharelife.service.oauth.CustomOAuth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AccountDetailService accountDetailService;
    @Autowired
    private JwtEntryPoint jwtEntryPoint;
    @Bean
    public JwtTokenFilter jwtTokenFilter(){
        return new JwtTokenFilter();
    }
    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(accountDetailService)
                .passwordEncoder(passwordEncoder());
    }
    @Bean
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
    @Autowired
    private AccountServiceImpl userService;
    @Autowired
    private CustomOAuth2UserService oauthUserService;
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
            httpSecurity.cors().and().csrf().disable().
                    authorizeRequests().antMatchers("/**", "/", "/login", "/oauth/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .oauth2Login()
                    .loginPage("/login")
                    .userInfoEndpoint()
                    .userService(oauthUserService)
                    .and()
                    .successHandler(new AuthenticationSuccessHandler() {

                        @Override
                        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                            Authentication authentication) throws IOException, ServletException {

                            DefaultOidcUser oauthUser = (DefaultOidcUser) authentication.getPrincipal();
                            String name = oauthUser.getAttribute("name");
                            System.out.println(name);
                            System.out.println(authentication);
                            String password = passwordEncoder().encode(oauthUser.getEmail());
                            userService.processOAuthPostLogin(name, oauthUser.getEmail(), password);
                            SecurityContextHolder.getContext().setAuthentication(authentication);
                            response.sendRedirect("/api/auth/signin-oauth");
                        }
                    })
                    .and()
                    .logout().logoutSuccessUrl("/").permitAll()
                    .and().exceptionHandling()
                    .authenticationEntryPoint(jwtEntryPoint)
                    .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            httpSecurity.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        }
}
