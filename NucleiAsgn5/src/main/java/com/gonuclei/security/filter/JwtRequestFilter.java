package com.gonuclei.security.filter;

import com.gonuclei.constants.Constants;
import com.gonuclei.security.JwtUtil;
import com.gonuclei.security.MyUserDetailsService;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * The type Jwt request filter.
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

  /**
   * The My user details service.
   */
  @Autowired
  private MyUserDetailsService myUserDetailsService;

  /**
   * The Jwt util.
   */
  @Autowired
  private JwtUtil jwtUtil;

  /**
   * Do filter internal.
   *
   * @param request     the request
   * @param response    the response
   * @param filterChain the filter chain
   * @throws ServletException the servlet exception
   * @throws IOException      the io exception
   */
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
    FilterChain filterChain) throws ServletException, IOException {

    final String authenticationHeader = request.getHeader(Constants.AUTHORIZATION);

    String username = null;
    String jwt = null;

    if (authenticationHeader != null && authenticationHeader.startsWith("Bearer ")) {
      jwt = authenticationHeader.substring(Constants.JWT_TOKEN_SUBSTRING);
      username = jwtUtil.extractUsername(jwt);
    }

    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

      UserDetails userDetails = this.myUserDetailsService.loadUserByUsername(username);

      if (jwtUtil.validateToken(jwt, userDetails)) {

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
          new UsernamePasswordAuthenticationToken(userDetails, null,
            userDetails.getAuthorities());
        usernamePasswordAuthenticationToken
          .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
      }
    }
    filterChain.doFilter(request, response);
  }
}
