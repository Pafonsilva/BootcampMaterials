package org.academia.persistence.jpa.associations.many2many;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_many2many")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;

    @ManyToMany(
            // when fetching user, go ahead and fetch all associated security groups
            fetch = FetchType.EAGER,
            // careful with CascadeType.Remove it might remove all entities
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}
    )
    private Set<SecurityGroup> securityGroups;

    public User() {
        this.securityGroups = new HashSet<SecurityGroup>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<SecurityGroup> getSecurityGroups() {
        return securityGroups;
    }

    public void addSecurityGroup(SecurityGroup securityGroup) {
        securityGroups.add(securityGroup);
        securityGroup.getUsers().add(this);
    }

    public void removeSecurityGroup(SecurityGroup securityGroup) {
        securityGroups.remove(securityGroup);
        securityGroup.getUsers().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        return username != null ? username.equals(user.username) : user.username == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", securityGroups=" + securityGroups +
                '}';
    }

    public SecurityGroup getSecurityGroup(String name) {

        for (SecurityGroup sg : securityGroups) {

            if (sg.getName().equals(name)) {
                return sg;
            }

        }

        return null;
    }
}
