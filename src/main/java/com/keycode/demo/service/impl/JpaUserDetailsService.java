package com.keycode.demo.service.impl;

import com.keycode.demo.model.Cliente;
import com.keycode.demo.model.SecurityCliente;
import com.keycode.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaUserDetailsService implements UserDetailsService{
    @Autowired
    private  ClienteRepository clienteRepository;


    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        Cliente cliente = clienteRepository
                .findByNombre(nombre);
        if (cliente == null){
            throw new UsernameNotFoundException("Error en el Login");
        }
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(cliente.getRol().getNombre()));
        return new User(cliente.getNombre(), cliente.getPassword(),authorities);
    }
}
