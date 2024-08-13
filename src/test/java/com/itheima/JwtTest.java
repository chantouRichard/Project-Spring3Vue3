package com.itheima;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testGen(){

        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("username","张三");
        //生成Jwt的代码
        String token = JWT.create()
                .withClaim("user", claims)//添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 30))//添加过期时间
                .sign(Algorithm.HMAC256("itheima"));//制定算法，配置秘钥

        System.out.println(token);
    }

//    @Test
//    public void testParse()
//    {
//        //定义字符串，模拟用户传递的token
//        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6IuW8oOS4iSJ9LCJleHAiOjE3MjMyNTk2MjB9.QgBVgyuGItH2_RzhmAokyMrmMQS70CVA_CEfANSY1Mg";
//
//        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("itheima")).build();
//
//        DecodedJWT decodedJWT = jwtVerifier.verify(token);
//        Map<String, Claim> claims = decodedJWT.getClaims();
//        System.out.println(claims.get("user"));
//    }
}
