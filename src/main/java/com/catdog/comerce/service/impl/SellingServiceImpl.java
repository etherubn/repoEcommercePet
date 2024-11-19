package com.catdog.comerce.service.impl;

import com.catdog.comerce.dto.request.SellingDto;
import com.catdog.comerce.entity.Selling;
import com.catdog.comerce.exception.AlreadyExistsException;
import com.catdog.comerce.repository.RepoGeneric;
import com.catdog.comerce.repository.SellingRepo;
import com.catdog.comerce.service.ISellingService;
import com.catdog.comerce.utils.MapperUtil;

import java.util.Optional;

public class SellingServiceImpl extends CrudServiceImpl<SellingDto, Selling,Long> implements ISellingService {
    private SellingRepo sellingRepo;

    public SellingServiceImpl(MapperUtil mapperUtil) {
        super(mapperUtil);
    }

    @Override
    protected RepoGeneric<Selling, Long> getRepo() {
        return sellingRepo;
    }

    @Override
    protected Class<Selling> getEntityClass() {
        return Selling.class;
    }

    @Override
    protected Class<SellingDto> getDtoClass() {
        return SellingDto.class;
    }

    @Override
    protected void setId(Selling entity, Long aLong) {
        entity.setIdSelling(aLong);
    }

    @Override
    public SellingDto create(SellingDto sellingDto) {
        //Todo: Falta implementar crear



        return null;
    }


}
