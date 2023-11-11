package admin_user.service;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
										Authentication authentication) throws IOException, ServletException {
		if (authentication != null) {
			var authorities = authentication.getAuthorities();
			var roles = authorities.stream().map(GrantedAuthority::getAuthority).findFirst();

			if (roles.orElse("").equals("ADMIN") || roles.orElse("").equals("USER")) {
				response.sendRedirect("/v1/dashboard");
			} else {
				response.sendRedirect("/error");
			}
		} else {
			response.sendRedirect("/login");
		}
	}
}
