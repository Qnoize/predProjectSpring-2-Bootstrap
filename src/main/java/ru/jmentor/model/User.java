package ru.jmentor.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "userTable")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "userPassword")
    private String userPassword;

    @Column(name = "userEmail")
    private String userEmail;

    @ManyToMany(
            targetEntity = Role.class,
            fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "userRole",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<Role> role = new HashSet<>();

    public User() { }

    public User(String userName, String userPassword, String userEmail) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }

    public User(Long userId, String userName, String userPassword, String userEmail) {
        this.id = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }

    public Long getId() { return id; }

    public String getUserName() { return userName; }

    public String getUserPassword() { return userPassword; }

    public String getUserEmail() { return userEmail; }

    public void setId(Long id) { this.id = id; }

    public void setUserName(String userName) { this.userName = userName; }

    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }

    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public Set<Role> getRole() { return role; }

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
