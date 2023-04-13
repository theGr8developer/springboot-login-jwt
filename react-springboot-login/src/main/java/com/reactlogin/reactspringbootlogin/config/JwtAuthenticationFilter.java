package com.reactlogin.reactspringbootlogin.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

    @Autowired
    CustomUserDetailService userDetailService;

    @Autowired
    JwtTokenHelper jwtTokenHelper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        // 1. Get Token
        String requestToken = request.getHeader("Authorization");
        System.out.println(requestToken);

        String username = null;
        String token = null;

        if(requestToken != null && requestToken.startsWith("Bearer")){
           token =  requestToken.substring(7);
           try {
               username = this.jwtTokenHelper.getUsernameFromToken(token);
            
           } catch (IllegalArgumentException e) {
            // TODO: handle exception
            System.out.println("illegel argument exception");
           }
           catch(ExpiredJwtException e){
                System.out.println("expired jwt exception");
           }
           catch(MalformedJwtException e){
            System.out.println("invalid token");
           }
        }
        else{
            System.out.println("requestToken is not begin with bearer");
        }

        // Once we get token, now validate

        if(username!=null && SecurityContextHolder.getContext().getAuthentication() == null){

            UserDetails userDetails = this.userDetailService.loadUserByUsername(username);
            if(this.jwtTokenHelper.validateToken(token, userDetails)){
                //sahi chal rha h 
                //Authentication krna h time 26:30

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
            else{
                System.out.println("Invalid jwt token");
            }

        }
        else{
            System.out.println("username is null and context is not null");
        }

        filterChain.doFilter(request, response);
    }
    
}
