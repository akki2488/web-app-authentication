package com.gbss.auth.model;

import com.gbss.framework.core.model.entities.Base;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.util.Set;

/**
 * Created by Akshay Misra on 15-11-2018.
 */
@Document(collection="users")
public class User extends Base {

    @NotBlank
    @Size(min=5)
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private String userName;

    @NotBlank
    @Size(min=8)
    private String password;

    private String passwordResetToken;

    private String firstName;

    private String lastName;

    @NotBlank
    @Email(message="{errors.invalid_email}")
    @Indexed(unique=true)
    private String email;

    @Nullable
    @Indexed(unique=true)
    private BigInteger mobile;

    private boolean enabled;

    @DBRef(lazy = true)
    private Set<Role> roles;

    @Override
    public void setObjectTypeId(String objectTypeId) {
        super.setObjectTypeId("5eee9edd37f5cc0de602cea3");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        this.setName(userName);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordResetToken() {
        return passwordResetToken;
    }

    public void setPasswordResetToken(String passwordResetToken) {
        this.passwordResetToken = passwordResetToken;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getMobile() {
        return mobile;
    }

    public void setMobile(BigInteger mobile) {
        this.mobile = mobile;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%s, " +
                        "userName='%s', " +
                        "password='%s', " +
                        "firstName='%s', " +
                        "lastName='%s', " +
                        "email='%s', " +
                        "mobile='%s', " +
                        "enabled='%s', " +
                        "roles='%s', " +
                        "createdAt='%s']",
                getId(), userName, password, firstName, lastName,
                email, mobile, enabled, roles, getCreatedAt());
    }
}
