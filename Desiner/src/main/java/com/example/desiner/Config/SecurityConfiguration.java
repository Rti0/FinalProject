package com.example.desiner.Config;

import com.example.desiner.Service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final MyUserDetailsService myUserDetailsService;
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(myUserDetailsService);
        authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authenticationProvider;
    }
    //regayah
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        //نوع من انواع الهجمات
        // أولا اوقف الهجمه
        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .authenticationProvider(authenticationProvider())
                //request api
                .authorizeHttpRequests()

                //auth class
                .requestMatchers("/api/v1/auth/registerCustomer").permitAll()
                .requestMatchers("/api/v1/auth/registerDesigner").permitAll()
                .requestMatchers("/api/v1/auth/login").permitAll()
//customer
                .requestMatchers("/api/v1/customer/get").permitAll()
                .requestMatchers("/api/v1/customer/add").permitAll()

                .requestMatchers("/api/v1/customer/update").hasAuthority("CUSTOMER")
                .requestMatchers("/api/v1/customer/delete").hasAuthority("CUSTOMER")
                .requestMatchers("/api/v1/customer/get-name/{name}").hasAuthority("CUSTOMER")
//designer
                .requestMatchers("/api/v1/designer/get").permitAll()
                .requestMatchers("/api/v1/designer/add").permitAll()
                .requestMatchers("/api/v1/designer/update").hasAuthority("DESIGNER")
                .requestMatchers("/api/v1/designer/delete").hasAuthority("DESIGNER")
                .requestMatchers( "/api/v1/designer/customer-id/{customerId}").permitAll()
                .requestMatchers( "/api/v1/designer/get-name/{name}").permitAll()
                //ORDER
                .requestMatchers("/api/v1/order/get").permitAll()
                .requestMatchers("/api/v1/order/addOrder/{servicesId}").hasAuthority("CUSTOMER")
                .requestMatchers("/api/v1/order/update").hasAuthority("CUSTOMER")
                .requestMatchers("/api/v1/order/delete").hasAuthority("DESIGNER")
                .requestMatchers( "/api/v1/order/status/{orderId}/{status}").permitAll()
                .requestMatchers( "/api/v1/order/status/get-status/{orderId}").permitAll()
                .requestMatchers("/api/v1/order/get-customers").hasAuthority("DESIGNER")
//                .requestMatchers("/api/v1/order/")
//DESIGNER B
                .requestMatchers("/api/v1/DB/get").permitAll()
                .requestMatchers("/api/v1/DB/add").hasAuthority("DESIGNER")
                .requestMatchers("/api/v1/DB/update/{id}").hasAuthority("DESIGNER")
                .requestMatchers("/api/v1/DB/delete/{id}").hasAuthority("DESIGNER")
//Services
                .requestMatchers("/api/v1/services/get").permitAll()
                .requestMatchers("/api/v1/services/add").permitAll()
                .requestMatchers("/api/v1/services/update/{id}").permitAll()
                .requestMatchers("/api/v1/services/delete/{id}").permitAll()
                .requestMatchers("/api/v1/services/delete/assign/{servicesId}/{designerId}").permitAll()
                .requestMatchers("/api/v1/services/delete/services-id/{id}").permitAll()
                //image
                .requestMatchers("/api/v1/Image/get").permitAll()
                .requestMatchers("/api/v1/Image/add").hasAuthority("DESIGNER")
                .requestMatchers("/api/v1/Image/update/{id}").hasAuthority("DESIGNER")
                .requestMatchers("/api/v1/Image/delete/{id}").hasAuthority("DESIGNER")
//RATEorder
                .requestMatchers("/api/v1/rate/get").permitAll()
                .requestMatchers("addOrder/{customerId}/{orderId}").hasAuthority("CUSTOMER")

                //.requestMatchers
                  .anyRequest().permitAll()
                // .authenticated()  مفتوح للكل
//                .anyRequest().authenticated()
                .and()

                //logout()> delete cookies
                .logout().logoutUrl("/api/v1/auth/logout")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .and()
                .httpBasic();
        return http.build();
    }
}
