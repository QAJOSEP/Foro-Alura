package com.alura.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alura.repository.IUsuarioRepo;

import com.alura.model.Usuario;
import lombok.RequiredArgsConstructor;

// Clase 2: cambia en relación a la lógica de negocio
@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
    
    private final IUsuarioRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = repo.findOneByUsername(username);
        
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        
        List<GrantedAuthority> roles = new ArrayList<>();
        String role = user.getRole().getName();
        roles.add(new SimpleGrantedAuthority(role));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
    }
    
}
