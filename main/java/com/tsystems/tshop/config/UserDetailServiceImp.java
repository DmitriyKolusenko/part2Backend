package com.tsystems.tshop.config;

import com.tsystems.tshop.domain.Client;
import com.tsystems.tshop.services.ClientService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserDetailServiceImp implements UserDetailsService {

    private final ClientService clientService;

    public UserDetailServiceImp(final ClientService clientService){this.clientService = clientService;}

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Client client = clientService.getClientByName(s);
        User.UserBuilder builder = null;
        builder = User.withUsername(s);
        builder.disabled(false);
        builder.password(client.getPassword());
        builder.authorities(client.getRoles());
        return builder.build();
    }
}
