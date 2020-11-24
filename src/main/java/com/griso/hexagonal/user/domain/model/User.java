package com.griso.hexagonal.user.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "user")
public class User {

    @Id
    private String id;

    private String username;

    private String password;

    private String name;

    private String surname;

    private Date birthday;

    private boolean active;

    private String roles = "";

    private String permissions = "";

    public List<String> getRoleList() {
        List<String> roleList = new ArrayList<>();
        if(!roles.trim().isEmpty()) {
            roleList.addAll(Arrays.asList(roles.split(";")));
        }

        return roleList;
    }

    public List<String> getPermissionList() {
        List<String> permissionList = new ArrayList<>();
        if(!permissions.trim().isEmpty()) {
            permissionList.addAll(Arrays.asList(permissions.split(";")));
        }

        return permissionList;
    }

    public void setRoleList(List<String> roleList) {
        this.roles = String.join(";", roleList);
    }

    public void setPermissionList(List<String> permissionList) {
        this.permissions = String.join(";", permissionList);
    }

}
