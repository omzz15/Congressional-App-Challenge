package org.moba.appchallenge22.services;

import org.moba.appchallenge22.domains.DomainObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.support.DomainClassConverter;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public abstract class CRUDServiceImpl<T extends DomainObject, ID extends Serializable, REPOSITORY extends JpaRepository<T, ID>> implements CRUDService<T, ID>{
    protected REPOSITORY repository;
    private String name;//just used for errors

    public CRUDServiceImpl() {
    }

    public CRUDServiceImpl(String name) {
        this.name = name;
    }

    public abstract void setRepository(REPOSITORY repository);

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public T getById(ID id) {
        return repository.findById(id).orElseThrow(() -> new IllegalStateException("no " + name + " exists with id " + id));
    }

    @Override
    public void addOrUpdate(T object) {
        repository.save(object);
    }

    @Override
    public void delete(ID id) {
        repository.delete(repository.findById(id).orElseThrow(() -> new IllegalStateException(name + " with id " + id + " can't be deleted because it doesn't exist")));
    }

    @Override
    public void delete(T object) {
        repository.delete(object);
    }
}
