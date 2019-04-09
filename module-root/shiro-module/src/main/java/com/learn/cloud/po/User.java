package com.learn.cloud.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 类名称:User
 * 类描述:TODO
 * 创建人:Administrator
 * 创建时间:2019/4/9 16:16
 * Version 1.0
 */
@Entity
@Table(name = "user_t")
public class User implements Serializable {

    private static final long serialVersionUID = -3320971805590503443L;

    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String password;
    private String salt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role_t",
            joinColumns = {
                @JoinColumn(name = "uid")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "rid")
            })
    private List<Role> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getCredentialsSalt() {
        return username + salt + salt;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + "]";
    }
}