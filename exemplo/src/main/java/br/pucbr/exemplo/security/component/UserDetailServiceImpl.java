package br.pucbr.exemplo.security.component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailServiceImpl.class);

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDetailServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException, DataAccessException {

        try {

            UserDetails u = new CustomUser("cleverson",
                    "$2a$12$LlxKRPHgE2I41V9o2hcN5ud.4dRUA67QCZhDUbh9C6GevJBoyoPo2",
                    true,
                    true,
                    true,
                    true,
                    new ArrayList<>(),
                    null);

            logger.info("Username: " + userName + " encontrado.");

            return u;
        } catch (Exception ex) {
            logger.error("Username: " + userName + " não econtrado na base. Acesso negado. ");
            throw new UsernameNotFoundException(userName);
        }

    }

    private CustomUser getCustomUser(String userName) {

        logger.info("getCustomUser: " + userName + ".");

        CustomUser customUser = jdbcTemplate.queryForObject(
                "select email, senha, guidusuario from usuario where email=?", new Object[] { userName },
                new UserRowMapper());

        if (customUser != null) {

            customUser = new CustomUser(customUser.getUsername(), customUser.getPassword(), customUser.isEnabled(),
                    customUser.isAccountNonExpired(), customUser.isCredentialsNonExpired(),
                    customUser.isAccountNonLocked(), getUserRoles(customUser), customUser.getGuidUsuario());
        }

        return customUser;

    }

    private class UserRowMapper implements RowMapper<CustomUser> {
        @Override
        public CustomUser mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new CustomUser(rs.getString("email"), rs.getString("senha"), true, true, true, true,
                    Collections.emptyList(), rs.getInt("guidusuario"));

        }
    }

    private List<GrantedAuthority> getUserRoles(CustomUser user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ADMIN"));
        return authorities;
    }

}
