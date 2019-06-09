package company.example.model.entity;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    ADMIN, CLIENT;

    @Override
    public String getAuthority() {
        return name();
    }
}
