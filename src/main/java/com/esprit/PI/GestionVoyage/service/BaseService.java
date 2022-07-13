package com.esprit.PI.GestionVoyage.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.List;

public interface BaseService<M,I,E> {

    Object           create(E entity);
    Object           update(I id, E entity) ;
    boolean     delete(I id) ;
    Object           getOne(I id) ;
    List<E>     getAll();
    Page<E> getAll(Pageable pageable);
}
