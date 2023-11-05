package org.academia.persistence.jpa.associations.many2many;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sgroup")
public class SecurityGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(
            // do not fetch associated users when fetching role
            fetch = FetchType.LAZY,
            mappedBy = "securityGroups"
    )
    private Set<User> users;

    public SecurityGroup() {
        users = new HashSet<User>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SecurityGroup that = (SecurityGroup) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        return users.equals(that.users);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "SecurityGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
