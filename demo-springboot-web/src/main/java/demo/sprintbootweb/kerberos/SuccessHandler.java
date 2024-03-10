package demo.sprintbootweb.kerberos;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.kerberos.authentication.KerberosServiceRequestToken;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        KerberosServiceRequestToken token = (KerberosServiceRequestToken) authentication;

        if(token.hasResponseToken()) {

            User user = (User) token.getPrincipal();
        }

    }
}
