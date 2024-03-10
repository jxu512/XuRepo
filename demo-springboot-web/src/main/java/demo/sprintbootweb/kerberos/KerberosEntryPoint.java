package demo.sprintbootweb.kerberos;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class KerberosEntryPoint implements AuthenticationEntryPoint, AuthenticationFailureHandler {


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        commence(response, authException);
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        commence(response, exception);
    }

    private void commence(HttpServletResponse response, AuthenticationException exception) {
        response.addHeader("WWW-Authenticate", "Negotiate");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
