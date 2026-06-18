package com.example.CityTrail.Entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List; 
import jakarta.validation.constraints.*;


@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "username can not be blank")
    @Size(min = 3, max = 15, message = "sernames needs to be between 3 to 15 characters")
    private String username;

    @NotBlank(message =  "password can not be blank")
    @Size(min = 5, message = "password needs to be 5 characters minimum")
    private String password;

    @Column(unique = true)
    @NotBlank(message = "email can not be blank")
    @Email(message = "you need a valid email")
    private String email;

    @Column(nullable = false)
    private String role = "ROLE_USER"; // "ROLE_USER" ou "ROLE_ADMIN"

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }

    protected User() {}

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, username='%s', email='%s']",
                id, username, email);
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getRole(){return role;}

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setRole(String role){
        this.role = role;
    }
}