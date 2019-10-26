package ru.jmentor.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "roleTable")
public class Role {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userRole")
    private String userRole;

    @ManyToMany
    @JoinTable(
            name = "userRole",
            joinColumns = @JoinColumn(name = "roleId"),
            inverseJoinColumns = @JoinColumn(name = "userId"))
    private Set<User> users = new HashSet<>();

    public Role() { }

    public Role(Long id, String userRole) { }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getUserRole() { return userRole; }

    public void setUserRole(String userRole) { this.userRole = userRole; }

    public Set<User> getUsers() { return users; }

    public void setUsers(Set<User> users) { this.users = users; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return userRole.equals(role.userRole);
    }

    @Override
    public int hashCode() { return Objects.hash(userRole); }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}
