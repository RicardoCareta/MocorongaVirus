package com.rd.mocoronga.backend.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.rd.mocoronga.backend.exception.ApiErrorRequest;
import com.rd.mocoronga.backend.service.LoginService;

//TODO Refactor Token validation
public class TokenRequestFilter implements Filter{

	@Autowired
	private LoginService loginService;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		if (!req.getRequestURI().equals("/login")) {
			final String requestTokenHeader = req.getHeader("Authorization");
			try {
				System.out.println(requestTokenHeader);
				if (requestTokenHeader == null) {
					throw new ApiErrorRequest("Invalid token1", HttpStatus.BAD_REQUEST);
				}
				
				if (!requestTokenHeader.startsWith("Bearer ")) {
					throw new ApiErrorRequest("Invalid token2", HttpStatus.BAD_REQUEST);
				}
				
				if (!loginService.authenticateToken(requestTokenHeader.substring(7))) {
					throw new ApiErrorRequest("Invalid token3", HttpStatus.BAD_REQUEST);
				}
				
				
			} 
			catch (ApiErrorRequest err) {
				HttpServletResponse res = (HttpServletResponse) response;
				res.sendError(err.getStatus().value(), err.getMessage());
			}
			chain.doFilter(request, response);
		}
		else {
			chain.doFilter(request, response);
		}
	}
	
}
