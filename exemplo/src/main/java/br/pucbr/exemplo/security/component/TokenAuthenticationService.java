package br.pucbr.exemplo.security.component;

import br.pucbr.exemplo.security.model.Autenticacao;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenAuthenticationService {

    // EXPIRATION_TIME = 100 anos
    static final long EXPIRATION_TIME = (100 * 365 * 24 * 60 * 60 * 1000);
    static final String SECRET = "AulaPuc";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    public static Autenticacao getToken(HttpServletResponse response, String username,
                                        Collection<? extends GrantedAuthority> authorities, Integer guidUsuario) {
        String token = Jwts.builder()
                .setSubject(username)
                 .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();

        Autenticacao autenticacao = new Autenticacao();
        autenticacao.setToken(token);
        autenticacao.setLogin(username);

        return autenticacao;
    }

    @SuppressWarnings("unchecked")
    public static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);

        if (token != null) {
            // faz parse do token
            Claims claims = null;

            try {
                claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody();
            } catch (ExpiredJwtException e) {
                claims = e.getClaims();
            }

            if (claims != null) {

                if (claims.getSubject() != null) {
                    return new UsernamePasswordAuthenticationToken(claims.getSubject(),new ArrayList<>(), new ArrayList<>());
                }

            }
        }
        return null;
    }

    public static Map<String, String> getValuesFromToken(HttpServletRequest request) {

        String token = request.getHeader(HEADER_STRING);

        if (token != null) {

            // faz parse do token
            Claims claims = null;

            try {

                claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody();

            } catch (ExpiredJwtException e) {
                claims = e.getClaims();
            }

            if (claims != null) {

                Map<String, String> values = new HashMap<String, String>();

                Integer guidUsuario = (Integer) claims.get("GUIDUSUARIO");
                values.put("guidUsuario", guidUsuario == null ? null : guidUsuario.toString());

                return values;

            }

        }

        return null;
    }

}
