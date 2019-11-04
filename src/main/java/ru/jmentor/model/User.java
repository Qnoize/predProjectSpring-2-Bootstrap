package ru.jmentor.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "userTable")
public class User {
    private Long id;
    private String userName;
    private String userPassword;
    private String userEmail;
    private Set<Role> role = new HashSet<>();

    public User() { }

    public User(String userName, String userPassword, String userEmail) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }

    public User(Long id, String userName, String userPassword, String userEmail) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }

    public User(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.userPassword = user.getUserPassword();
        this.userEmail = user.getUserEmail();
        this.role = user.getRole();
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() { return id; }

    @Column(name = "userName")
    public String getUserName() { return userName; }

    @Column(name = "userPassword")
    public String getUserPassword() { return userPassword; }

    @Column(name = "userEmail")
    public String getUserEmail() { return userEmail; }

    @ManyToMany(
            targetEntity = Role.class,
            fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "userRole",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    public Set<Role> getRole() { return role; }

    public void setId(Long id) { this.id = id; }

    public void setUserName(String userName) { this.userName = userName; }

    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }

    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public void setRole(Set<Role> role) { this.role = role; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return userName.equals(user.userName) &&
                userPassword.equals(user.userPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userPassword);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
