package com.jagdi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationConverter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jagdi.entities.User;
import com.jagdi.repositories.UserRepository;
import com.jagdi.services.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	UserService userService;

	private BasicAuthenticationConverter authenticationConverter = new BasicAuthenticationConverter();

	List<String> excludeUrlPatterns = (List<String>) Arrays.asList("/v3/api-docs/**", "/swagger-ui/**",
			"/swagger-ui.html");
	AntPathMatcher pathMatcher = new AntPathMatcher();

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String path = request.getRequestURI();
		System.out.println(path);
		if (excludeUrlPatterns.contains(path)) {
			filterChain.doFilter(request, response);
			return;
		}
		request.getHeader("Authorization");
		UsernamePasswordAuthenticationToken authRequest = this.authenticationConverter.convert(request);
		String username = authRequest.getName();
		User user = (User) userService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null,
				Collections.emptyList());
		authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);

		filterChain.doFilter(request, response);

	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		return excludeUrlPatterns.stream().anyMatch(p -> pathMatcher.match((String) p, request.getRequestURI()));
	}

}
