package ru.kata.spring.boot_security.demo.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "role")
    private String role;

    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {

    }

    public Role(Long id) {
        this.id = id;
    }

    public Role(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return role;
    }

    public void setName(String role) {
        this.role = role;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return getName();
    }

    @Override
    public String toString() {
        return role;
//        if (role.equals("ROLE_ADMIN")) {
//            return "ADMIN";
//        } else if (role.equals("ROLE_USER")) {
//            return "USER";
//        }else return "ADMIN, USER";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        if (id == null) {
            if (role.id != null)
                return false;
        } else if (!id.equals(role.id))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
