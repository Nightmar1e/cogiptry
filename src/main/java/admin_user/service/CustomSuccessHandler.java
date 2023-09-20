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

			if (roles.orElse("").equals("ADMIN")) {
				response.sendRedirect("/admin-page");
			} else if (roles.orElse("").equals("USER")) {
				response.sendRedirect("/user-page");
			} else {
				response.sendRedirect("/error");
			}
		} else {
			// Handle the case where authentication is null (e.g., unauthorized access)
			response.sendRedirect("/login"); // Redirect to the login page or an error page.
		}
	}

}
