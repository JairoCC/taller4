package com.keycode.demo.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class SecurityCliente implements UserDetails {

    private Cliente cliente;

    public SecurityCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String getUsername() {
        return cliente.getNombre();
    }

    @Override
    public String getPassword() {
        return cliente.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
