package com.jagdi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jagdi.entities.User;
import com.jagdi.repositories.UserRepository;
import com.jagdi.services.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	UserService userService;

	private BasicAuthenticationConverter authenticationConverter = new BasicAuthenticationConverter();

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		UsernamePasswordAuthenticationToken authRequest = this.authenticationConverter.convert(request);
		String username = authRequest.getName();
		User user = (User) userService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null,
				Collections.emptyList());
		authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);

		filterChain.doFilter(request, response);

	}

}
