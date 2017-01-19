package org.community.service;

import org.community.domain.User;
import org.community.domain.UserPrivilege;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by frodoking on 2017/1/16.
 */
@Service
public class OauthUserDetailsService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(OauthUserDetailsService.class);
    @Autowired
    private UserService userService;
    @Autowired
    private UserPrivilegeService userPrivilegeService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("loadUserByUsername >> " + username);
        final User user = userService.getByName(username);
        if (user == null)
            throw new UsernameNotFoundException(username);

        List<UserPrivilege> privileges = userPrivilegeService.getPrivilegesById(user.getId());
        final List<GrantedAuthority> grantedAuthorities = new ArrayList<>(privileges.size());
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        for (UserPrivilege privilege : privileges) {
            logger.info("loadUserByUsername >> " + username + ", privilege >> " + privilege.getPrivilege());
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + privilege.getPrivilege()));
        }
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return grantedAuthorities;
            }

            @Override
            public String getPassword() {
                return user.getPassword();
            }

            @Override
            public String getUsername() {
                return user.getUsername();
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
                return true/*user.getArchived()*/;
            }
        };
    }
}