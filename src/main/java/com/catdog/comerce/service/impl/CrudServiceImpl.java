package com.catdog.comerce.service.impl;

import com.catdog.comerce.exception.NotFoundException;
import com.catdog.comerce.repository.RepoGeneric;
import com.catdog.comerce.service.ICrudService;
import com.catdog.comerce.utils.MapperUtil;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
abstract class CrudServiceImpl<Dto,T,ID> implements ICrudService<Dto,ID> {
    protected abstract RepoGeneric<T,ID> getRepo();
    protected abstract Class<T> getEntityClass();
    protected abstract Class<Dto> getDtoClass();
    protected abstract void setId(T entity,ID id);
    protected final MapperUtil mapperUtil;

    @Override
    public List<Dto> findAll() {
        return mapperUtil.mapList(getRepo().findAll(),getDtoClass());
    }

    @Override
    public Dto create(Dto dto) {
        T t = mapperUtil.map(dto,getEntityClass());
        T savedEntity = getRepo().save(t);
        return mapperUtil.map(savedEntity,getDtoClass());
    }

    @Override
    public Dto update(Dto dto, ID id) {
        getRepo().findById(id).orElseThrow(()->new NotFoundException(getEntityClass().getSimpleName(), (Long) id));
        T entity = mapperUtil.map(dto,getEntityClass());
        setId(entity,id);
        T updatedEntity = getRepo().save(entity);


        return mapperUtil.map(updatedEntity,getDtoClass());
    }

    @Override
    public void delete(ID id) {
        getRepo().findById(id).orElseThrow(()->new NotFoundException(getEntityClass().getSimpleName(), (Long) id));
        getRepo().deleteById(id);
    }

    @Override
    public Dto getById(ID id) {
        T entity = getRepo().findById(id).orElseThrow(()->new NotFoundException(getEntityClass().getSimpleName(), (Long) id));
        return mapperUtil.map(entity,getDtoClass());
    }
}
