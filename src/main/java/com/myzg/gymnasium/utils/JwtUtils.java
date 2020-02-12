package com.myzg.gymnasium.utils;

import com.myzg.gymnasium.jwt.Const;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;


@Slf4j
@Component
public class JwtUtils implements Serializable {


    public Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try{
            claims = Jwts.parser()
                    .setSigningKey(Const.SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            log.error("[{}],查询claims 失败",token,e.getMessage());
            claims = null;
        }
        return claims;
    }

    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    public String getUserNameFromToken(String token) {
        Claims  claims = getClaimsFromToken(token);
        String userName = null;
        if(claims != null){
            try{
                userName  =  (String) claims.get("userName");
            }catch (Exception e){
                log.error("[{}],没有找到 userName 参数",token,e.getMessage());
                userName = null;
            }
        }
        return userName;
    }

    //如果权限时间是过去的就说明该认证已经过期
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        User user = (User) userDetails;
        String userName = getUserNameFromToken(token);
        return (userName.equals(user.getUsername()) && !isTokenExpired(token));
    }

    public String generateToken(String userName, Collection<? extends GrantedAuthority> authority) {
        Map<String,Object> maps = new HashMap<>();
        maps.put("userName", userName);
        maps.put("authority", authority);
        return generateToken(maps);
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + Const.EXPIRATION_TIME);
    }

    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, Const.SECRET )
                .compact();
    }

    public Collection getAuthorityFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        if(claims != null){
            Collection result = new ArrayList();
            Iterator iterator = claims.get("authority",Collection.class).iterator();
            while (iterator.hasNext()) {
                LinkedHashMap map = (LinkedHashMap) iterator.next();
                result.add(new SimpleGrantedAuthority((String)map.get("authority")));
            }
             return result;
        }else {
            return null;
        }
    }
}
