package com.devsuperior.bds04.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.devsuperior.bds04.entities.User;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String email;
    private Set<RoleDTO> roles = new HashSet<>();
    
    public UserDTO() {
    }

    public UserDTO(Long id,  String email, Set<RoleDTO> roles) {
        this.id = id;
        this.email = email;
        this.roles = roles;
    }

    public UserDTO(User entity) {
        id = entity.getId();

        email = entity.getEmail();
        roles = entity.getRoles().stream().map(RoleDTO::new).collect(Collectors.toSet());
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<RoleDTO> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<RoleDTO> roles) {
        this.roles = roles;
    }

}
