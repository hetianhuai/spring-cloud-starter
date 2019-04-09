package com.learn.cloud.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 类名称:Permission
 * 类描述:TODO
 * 创建人:Administrator
 * 创建时间:2019/4/9 16:16
 * Version 1.0
 */
@Entity
@Table(name = "permission_t")
public class Permission implements Serializable {

    private static final long serialVersionUID = 353629772108330570L;

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "role_permission_t",
            joinColumns = {
                    @JoinColumn(name = "pid")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "rid")
            })
    private List<Role> roles;

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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}