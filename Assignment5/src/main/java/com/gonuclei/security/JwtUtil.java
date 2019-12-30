package com.gonuclei.security;

import com.gonuclei.constants.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * The type Jwt util.
 */
@Service
public class JwtUtil {

  @Value("spring.security.jwt-secret")
  private String SECRET;

  /**
   * Extract username string.
   *
   * @param token the token
   * @return the string
   */
  public String extractUsername(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  /**
   * Extract expiration date.
   *
   * @param token the token
   * @return the date
   */
  public Date extractExpiration(String token) {
    return extractClaim(token, Claims::getExpiration);
  }

  /**
   * Extract claim t.
   *
   * @param <T>            the type parameter
   * @param token          the token
   * @param claimsResolver the claims resolver
   * @return the t
   */
  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  /**
   * Extract all claims claims.
   *
   * @param token the token
   * @return the claims
   */
  private Claims extractAllClaims(String token) {
    return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
  }

  /**
   * Is token expired boolean.
   *
   * @param token the token
   * @return the boolean
   */
  private Boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }

  /**
   * Generate token string.
   *
   * @param emailId the email id
   * @return the string
   */
  public String generateToken(String emailId) {
    Map<String, Object> claims = new HashMap<>();
    return createToken(claims, emailId);
  }

  /**
   * Create token string.
   *
   * @param claims  the claims
   * @param subject the subject
   * @return the string
   */
  public String createToken(Map<String, Object> claims, String subject) {
    return Jwts.builder().setClaims(claims).setSubject(subject)
      .setIssuedAt(new Date(System.currentTimeMillis()))
      .setExpiration(new Date(System.currentTimeMillis() + Constants.TOKEN_VALIDITY))
      .signWith(SignatureAlgorithm.HS256, SECRET).compact();
  }

  /**
   * Validate token boolean.
   *
   * @param token       the token
   * @param userDetails the user details
   * @return the boolean
   */
  public Boolean validateToken(String token, UserDetails userDetails) {
    final String username = extractUsername(token);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
  }
}
