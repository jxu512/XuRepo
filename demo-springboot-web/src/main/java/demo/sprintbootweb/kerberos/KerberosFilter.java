/*
    This will only work in environment where Kerberos authention is setup, like in company env
 */

package demo.sprintbootweb.kerberos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authorization.AuthorityAuthorizationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.kerberos.authentication.KerberosServiceAuthenticationProvider;
import org.springframework.security.kerberos.authentication.KerberosTicketValidator;
import org.springframework.security.kerberos.authentication.sun.SunJaasKerberosTicketValidator;
import org.springframework.security.kerberos.web.authentication.SpnegoAuthenticationProcessingFilter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.authorization.AuthorizationManagers;

import javax.servlet.Filter;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class KerberosFilter {

    //@Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{

        http
                .headers().frameOptions().sameOrigin().and()
                .exceptionHandling()
                    .accessDeniedHandler(new DeniedHandler())
                    .authenticationEntryPoint(new KerberosEntryPoint()).and()
                .addFilterBefore(spnegoFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests()
                    .requestMatchers("/admin")
                    .access(AuthorizationManagers.allOf(
                            AuthorityAuthorizationManager.hasAnyAuthority("ADMIN", "USYS"),
                            AuthorityAuthorizationManager.hasAnyAuthority("COMPLIANCE", "RISK")
                    ))
                .requestMatchers("/get")
                    .hasAnyAuthority("ADMIN", "SYS", "USER")
                .requestMatchers("/about")
                    .permitAll()
                .anyRequest()
                    .authenticated();

        return http.build();
    }

    private Filter spnegoFilter() {

        AuthenticationManager authenticationManager = new ProviderManager(
                Collections.singletonList(
                        kerberosAuthenticationProvider(new UserDetailsImpl()))
        );

        SpnegoAuthenticationProcessingFilter filter = new SpnegoAuthenticationProcessingFilter();
        filter.setAuthenticationManager(authenticationManager);
        filter.setSkipIfAlreadyAuthenticated(true);
        filter.setSuccessHandler(new SuccessHandler());

        return filter;
    }

    private KerberosServiceAuthenticationProvider kerberosAuthenticationProvider(UserDetailsImpl userDetails) {

        KerberosServiceAuthenticationProvider provider = new KerberosServiceAuthenticationProvider();
        provider.setUserDetailsService(userDetails);
        provider.setTicketValidator(kerberosTicketValidator());

        return provider;
    }

    private KerberosTicketValidator kerberosTicketValidator() {
        String principalId = "principal-id";
        String keytabFile = "/path/keytab";
        SunJaasKerberosTicketValidator ticketValidator = new SunJaasKerberosTicketValidator();

        ticketValidator.setServicePrincipal(principalId);
        ticketValidator.setKeyTabLocation(new FileSystemResource(keytabFile));

        return ticketValidator;

    }


}
