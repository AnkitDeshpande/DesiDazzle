package com.desidazzle.controller.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.desidazzle.model.Customer;
import com.desidazzle.repository.CustomerRepo;
import com.desidazzle.service.JWTService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JWTService jwtService;

	@Autowired
	private CustomerRepo customerRepo;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String tokenheader = request.getHeader("Authorization");
		if (tokenheader != null && tokenheader.startsWith("Bearer ")) {
			String token = tokenheader.substring(7);
			try {
				String username = jwtService.getUsername(token);
				Optional<Customer> optUser = customerRepo.findByUsernameIgnoreCase(username);
				if (optUser != null) {
					Customer cust = optUser.get();
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(cust,
							new ArrayList<>());
					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			} catch (JWTDecodeException ex) {

			}
		}
		filterChain.doFilter(request, response);
	}

}
