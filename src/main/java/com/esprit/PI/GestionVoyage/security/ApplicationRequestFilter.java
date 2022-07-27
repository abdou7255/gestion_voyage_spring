package com.esprit.PI.GestionVoyage.security;


import com.esprit.PI.GestionVoyage.service.auth.ApplicationCompanyDetailsService;
import com.esprit.PI.GestionVoyage.service.auth.ApplicationEmployeeDetailsService;
import com.esprit.PI.GestionVoyage.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ApplicationRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private ApplicationEmployeeDetailsService applicationUserDetailsService;
    @Autowired
    private ApplicationCompanyDetailsService applicationCompanyDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String path = httpServletRequest.getRequestURI();

        String authHeader=httpServletRequest.getHeader("Authorization");// f header mteaa request lezem ykoun aandy authorization
        String userName=null;
        String jwt=null;

        if(authHeader!=null&&authHeader.startsWith("Bearer ")){
            jwt=authHeader.substring(7);
            userName= jwtUtil.extractUsername(jwt);
        }
        if(userName != null&& SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails = null;
            if(path.contains("employee")) {
                userDetails=applicationUserDetailsService.loadUserByUsername(userName);
            } else if(path.contains("company")){
                userDetails=applicationCompanyDetailsService.loadUserByUsername(userName);
            }
            if(jwtUtil.validateToken(jwt,userDetails)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
                        new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }


        }

        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
