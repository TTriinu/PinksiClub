package com.developers.PinksiClub.repository;

import com.developers.PinksiClub.model.User;

import java.util.Collection;

public interface UserRepository<T extends User> {
     /*Basic CRUD Operator */
    T create(T data);
    Collection<T> list(int page, int pageSize);
    T get(Long id);
    T update(T data);
    Boolean delete(Long id);

            /* More Complex Operation */
}
