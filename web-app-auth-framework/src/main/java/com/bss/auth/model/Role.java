package com.bss.auth.model;

import com.bss.framework.core.schema.model.Base;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

/**
 * Created by Rocky on 15-11-2018.
 */
@Document(collection = "roles")
public class Role extends Base {

    public Role(String role, String description) {
        this.role = role;
    }

    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private String role;


    @DBRef
    private Set<Permission> permissions;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return String.format(
                "Role[id=%s, " +
                        "role='%s', " +
                        "description='%s']",
                getId(), role, getDescription());
    }
}
