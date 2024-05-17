package com.maidsTask.LibrarySystem.security;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.maidsTask.LibrarySystem.model.Patron;
import com.maidsTask.LibrarySystem.repository.PatronRepository;
import com.maidsTask.LibrarySystem.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Component
@AllArgsConstructor
public class IsAuth extends OncePerRequestFilter {
    private PatronRepository patronRepository;
    private JwtService jwtService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String tokenHeader=request.getHeader("Authorization");
        if (tokenHeader!=null &&tokenHeader.startsWith("Bearer ")){
            String token = tokenHeader.substring(7);
            try {
                String email= jwtService.getEmail(token);
                Optional<Patron> existUser=patronRepository.findByEmail(email);
                if (existUser.isPresent()) {
                    Patron user = existUser.get();
                    UsernamePasswordAuthenticationToken authentication=new UsernamePasswordAuthenticationToken(user,null,new ArrayList<>()) ;
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }

            }
            catch (JWTDecodeException exception){
                System.out.println("invalid token");
            }
        }

        filterChain.doFilter(request,response);

    }
}
