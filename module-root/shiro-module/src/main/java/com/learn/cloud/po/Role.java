package com.learn.cloud.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 类名称:Role
 * 类描述:TODO
 * 创建人:Administrator
 * 创建时间:2019/4/9 16:16
 * Version 1.0
 */
@Entity
@Table(name = "role_t")
public class Role implements Serializable {

    private static final long serialVersionUID = -8687790154329829056L;

    @Id
    @GeneratedValue
    private Integer id;
    private String role;

    @ManyToMany
    @JoinTable(
            name = "user_role_t",
            joinColumns = {
                    @JoinColumn(name = "rid")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "uid")
            })
    private List<User> users;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_permission_t",
            joinColumns = {
                    @JoinColumn(name = "rid")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "pid")
            })
    private List<Permission> permissions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}