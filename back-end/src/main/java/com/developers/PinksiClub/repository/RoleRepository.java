package com.developers.PinksiClub.repository;

import com.developers.PinksiClub.model.Role;

import java.util.Collection;

public interface RoleRepository<T extends Role> {
    /*Basic CRUD Operator */
    T create(T data);
    Collection<T> list(int page, int pageSize);
    T get(Long id);
    T update(T data);
    Boolean delete(Long id);

    /* More Complex Operation */
    void addRoleToUser(Long userId, String roleName);
    Role getRoleByUserId(Long userId);
    Role getRoleByUserEmail(String email);
    void updateUserRole(Long userId,String roleName);
    

}
