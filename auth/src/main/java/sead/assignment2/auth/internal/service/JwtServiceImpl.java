package sead.assignment2.auth.internal.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.DefaultClaims;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import sead.assignment2.auth.external.JwtService;
import sead.assignment2.external.dto.ExternalUserDto;
import sead.assignment2.external.enums.AuthRole;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {
    @Value("${spring.security.jwt.secret}")
    private String secretKey;

    @Value("${spring.security.jwt.expiration}")
    private Long jwtExpiration;

    public Boolean isValid(String token, UserDetails user) {
        String id = getUserIdFromJwt(token);
        return id.equals(user.getUsername()) && !isTokenExpired(token);
    }

    public Boolean isTokenExpired(String token) {
        return getExpirationDateFromJwt(token).before(new Date());
    }


    public String generateToken(ExternalUserDto dto) {
        Claims claims = new DefaultClaims();
        claims.put("authRole", dto.getAuthRole());

        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(String.valueOf(dto.getId()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(getSigningKey())
                .compact();

    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64URL.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Claims extractAllClaims(String token) {
        try {
            return Jwts
                    .parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (SignatureException e) {
            throw new IllegalArgumentException("Invalid JWT token");
        } catch (Exception e) {
            throw new IllegalArgumentException("Could not extract claims");
        }
    }

    public String getUserIdFromJwt(String token) {
        return extractAllClaims(token).getSubject();
    }

    public AuthRole getAuthRoleFromJwt(String token) {
        return AuthRole.valueOf(extractAllClaims(token).get("authRole", String.class));
    }

    private Date getExpirationDateFromJwt(String token) {
        return extractAllClaims(token).getExpiration();
    }
}
