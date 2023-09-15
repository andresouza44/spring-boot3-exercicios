package com.andre.usuariosApi.security;

import com.andre.usuariosApi.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

public class TokenUtil {
    private static final String HEADER ="Authorization";
    private static final String PREFIX = "Bearer ";
    private static final long EXPIRATION = 12*60*60*1000;
    private static final String SECRET_KEY = "12345678901234567890123456789012";
    private static final String EMISSOR = "DevNice";

    public static String createToken(Usuario usuario){
        Key secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        String token = Jwts.builder()
                .setSubject(usuario.getName())
                .setIssuer(EMISSOR)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
        return PREFIX + token;
        }

    private static boolean isExpirationValid(Date expiration) {
        return expiration.after(new Date(System.currentTimeMillis()));
    }
    private static boolean isEmissor (String emissor){
        return  emissor.equals(EMISSOR);
    }

    private static boolean isSubjectValid(String username){
        return username != null && username.length()>0;
    }

    public static UsernamePasswordAuthenticationToken validate(HttpServletRequest request){
        String token = request.getHeader(HEADER);
        token = token.replace(PREFIX,"");

        Jws<Claims> jwsClains = Jwts.parserBuilder().setSigningKey(SECRET_KEY.getBytes())
                .build()
                .parseClaimsJws(token);

        String userName = jwsClains.getBody().getSubject();
        String issuer = jwsClains.getBody().getIssuer();
        Date expira = jwsClains.getBody().getExpiration();

        if (isSubjectValid(userName) && isEmissor(issuer) && isExpirationValid(expira)){
            return  new UsernamePasswordAuthenticationToken(userName,null, Collections.emptyList() );
        }


        return null;
    }



}
