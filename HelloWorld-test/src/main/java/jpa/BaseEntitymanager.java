package jpa;

import java.util.List;

public interface BaseEntitymanager<K,E> {
    List<E> findAll();
    boolean add(E entity);
    boolean delete(E entity);
    E findById(K id);
    boolean update(E entity);
}
