package org.moba.appchallenge22.services;

import org.moba.appchallenge22.domains.DomainObject;

import java.io.Serializable;
import java.util.List;

public interface CRUDService<T extends DomainObject, ID extends Serializable> {
    List<T> getAll();

    T getById(ID id);

    void addOrUpdate(T object);

    void delete(ID id);

    void delete(T object);
}
