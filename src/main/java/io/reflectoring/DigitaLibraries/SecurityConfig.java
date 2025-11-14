package io.reflectoring.DigitaLibraries.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
{
    http.authorizeHttpRequests(req->req.anyRequest().authenticated())
            .formLogin(form->form.permitAll())
            .logout(LogoutConfigurer::permitAll);
return http.build();
}
@Bean
public PasswordEncoder passwordEncoder()
{
    return new BCryptPasswordEncoder();
}
@Bean
    public UserDetailsService users(PasswordEncoder passwordEncoder)
{
    UserDetails userDetails = User.withUsername("friendUser")
            .password(passwordEncoder.encode("12345"))
            .roles("FRIEND")
            .build();
    return new InMemoryUserDetailsManager(userDetails);
}


}
