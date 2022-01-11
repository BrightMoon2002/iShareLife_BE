package com.example.isharelife.security.jwt;

import com.example.isharelife.security.userprincipal.AccountPrinciple;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    //hàm create token được gọi qua login
    private static final Logger logger = LoggerFactory.getLogger((JwtProvider.class));
    private String jwtSecret = "duynh1618@gmail.com";
    private int jwtExpiration = 86400;
    public String createToken(Authentication authentication) {
        // lấy pricipal của hệ thông cho bằng của mình
        AccountPrinciple accountPrinciple = (AccountPrinciple) authentication.getPrincipal();
        return Jwts.builder().setSubject(accountPrinciple.getUsername()) //username
                .setIssuedAt(new Date()) // ngày
                .setExpiration(new Date(new Date().getTime()+jwtExpiration*10000)) //hạn token
                .signWith(SignatureAlgorithm.HS512, jwtSecret) //chữ ký có key là HS512
                .compact(); //compact là đóng gói lại
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJwt(token);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature -> Message: {}", e); // chữ kí không đúng
        } catch (MalformedJwtException e) {
            logger.error("Invalid format Token -> Message: {}", e); // token không đúng định dạng
        } catch (ExpiredJwtException e) {
            logger.error("Expired JWT token -> Message: {}", e); //token hết hạn
        } catch (UnsupportedJwtException e) {
            logger.error("Unsupported JWT toke -> Message: {}", e); // token không được hỗ trợ
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty --> Message {}", e); //token có khoảng trống không hợp lệ
        }
        return false;
    }
    // khi có token thì phải tìm lại username trong token đó để thực hiện hàm ở chỗ khác theo các request
    public String getUsernameFromToken(String token) {
        String username = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
        return username;
    }
}
