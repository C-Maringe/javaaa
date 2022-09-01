package com.fossil.assetmanagementsystem.services;

public interface BaseService <T,E> {
    T findById(Integer id);

    T save(E e);
    T update(Integer id,E e);
    Boolean deleteById(Integer id);
}

