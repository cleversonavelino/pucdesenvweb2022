package br.pucbr.exemplo.security.component;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {

    private static final long serialVersionUID = 1L;

    private Integer guidUsuario;

    public CustomUser(String username, String password,
                      boolean enabled, boolean accountNonExpired,
                      boolean credentialsNonExpired,
                      boolean accountNonLocked,
                      Collection<? extends GrantedAuthority> authorities,
                      Integer guidUsuario) {
        super(username == null ? "email não fornecido" : username, password == null ? "not required" : password,
                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.guidUsuario = guidUsuario;
    }

    public Integer getGuidUsuario() {
        return guidUsuario;
    }

    public void setGuidUsuario(Integer guidUsuario) {
        this.guidUsuario = guidUsuario;
    }

}
