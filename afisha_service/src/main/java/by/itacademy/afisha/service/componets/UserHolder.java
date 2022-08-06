package by.itacademy.afisha.service.componets;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.Collection;

@Component
public class UserHolder {

    public UserDetails getUser(){
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        String name = principal.getName();
        if(principal.getName() == "anonymousUser"){
            return new UserDetails() {
                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    return null;
                }

                @Override
                public String getPassword() {
                    return null;
                }

                @Override
                public String getUsername() {
                    return null;
                }

                @Override
                public boolean isAccountNonExpired() {
                    return false;
                }

                @Override
                public boolean isAccountNonLocked() {
                    return false;
                }

                @Override
                public boolean isCredentialsNonExpired() {
                    return false;
                }

                @Override
                public boolean isEnabled() {
                    return false;
                }
            };
        } else {
            return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }

    }

}
