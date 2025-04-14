package io.github.myselfshubham1.spring_boot_assignment.user.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    /**
     * Auto generated private key as ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * field for username
     */
    @NotBlank(message = "Username is required")
    private String username;

    /**
     * field for password
     */
    @NotBlank(message = "Password is required")
    private String password;

    /**
     * field for email
     */

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    private boolean active = true;


    /**
     * constructor
     */

    public User(boolean active, String email, Long id, String password, String username) {
        this.active = active;
        this.email = email;
        this.id = id;
        this.password = password;
        this.username = username;
    }

    /**
     * blank constructor
     */
    public User() {

    }

    /**
     * getter and setter
     */
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * equals part
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return active == user.active && Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(email, user.email);
    }

    /**
     * hashcode part
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, active);
    }

    /**
     * to -string part
     */
    @Override
    public String toString() {
        return "User{" +
                "active=" + active +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
