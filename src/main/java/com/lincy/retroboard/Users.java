package com.lincy.retroboard;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Adam Linczmayer
 */
@Data
@ToString(exclude = "password")
@Entity
public class Users {
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    private @Id @GeneratedValue Long id;

    private String name;

    private @JsonIgnore
    String password;

    private String[] roles;

    protected Users() {
    }

    public Users(String name, String password, String... roles) {

        this.name = name;
        this.setPassword(password);
        this.roles = roles;
    }

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    public static PasswordEncoder getPasswordEncoder() {
        return PASSWORD_ENCODER;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}