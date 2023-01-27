package com.xprod.spring.xprod.utility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.auth0.jwt.JWT;

import com.auth0.jwt.JWTVerifier;
import com.xprod.spring.xprod.domain.UserPrincipal;

import static com.xprod.spring.xprod.constant.SecurityConstant.*;
import static com.auth0.jwt.algorithms.Algorithm.HMAC512;



public class JWTTokenProvider {
	
	@Value("${jwt.secret}")
	private String secret;
	
	
	public String generateJwtToken(UserPrincipal userPrincipal) {
		String[] claims = getClaimsFromUser(userPrincipal);
		return JWT.create().withIssuer(GET_ARRAYS_XPROD).withAudience(GET_ARRAYS_ADMINISTRATION)
				.withIssuedAt(new Date()).withSubject(userPrincipal.getUsername())
				.withArrayClaim(AUTHORITIES,claims).withExpiresAt(new Date(System.currentTimeMillis()+ EXPIRATION_TIME))
				.sign(HMAC512(secret.getBytes()));
		
	}
	
	public List<GrantedAuthority>getAuthorities(String token){
		String[] claims = getClaimsFromToken(token);
		return stream(claims).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		
	}


	private String[] getClaimsFromToken(String token) {
		JWTVerifier verifier = getJWTVerifier();
		return verifier.verify(token).getClaim(AUTHORITIES).asArray(String.class);
	}

	

	private JWTVerifier getJWTVerifier() {
		
		return null;
	}

	private String[] getClaimsFromUser(UserPrincipal user) {
		List<String> authorities = new ArrayList<>();
		for(GrantedAuthority grantedAuthority : user.getAuthorities()) {
			authorities.add(grantedAuthority.getAuthority());
		}
		
		return authorities.toArray(new String[0]);
	}

}