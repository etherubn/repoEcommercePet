package com.catdog.comerce.service.impl;

import com.catdog.comerce.dto.request.SellingDto;
import com.catdog.comerce.dto.request.SellingProductDto;
import com.catdog.comerce.dto.response.ResponseProductSellingDto;
import com.catdog.comerce.dto.response.ResponseSelling;
import com.catdog.comerce.dto.response.ResponseUserSellingDto;
import com.catdog.comerce.entity.Product;
import com.catdog.comerce.entity.Selling;

import com.catdog.comerce.entity.SellingProduct;
import com.catdog.comerce.entity.User;
import com.catdog.comerce.exception.NotFoundException;
import com.catdog.comerce.exception.NotStockException;
import com.catdog.comerce.exception.RepeatedException;
import com.catdog.comerce.repository.*;
import com.catdog.comerce.service.ISellingService;
import com.catdog.comerce.utils.MapperUtil;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RequiredArgsConstructor
@Service
public class SellingServiceImpl extends CrudServiceImpl<SellingDto, Selling,Long> implements ISellingService {
    private final SellingRepo sellingRepo;
    private final ProductRepo productRepo;
    private final UserRepo userRepo;
    private final SellingProductRepo sellingProductRepo;



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

    //TODO Find all : falta


    @Transactional
    public ResponseSelling createSelling(SellingDto sellingDto) {

        User user = userRepo.findById(sellingDto.getUser().getIdUser()).orElseThrow(()->new NotFoundException("user",sellingDto.getUser().getIdUser()));

        ResponseUserSellingDto responseUserSellingDto = mapperUtil.map(user,ResponseUserSellingDto.class);

        BigDecimal total = BigDecimal.ZERO;

        List<ResponseProductSellingDto> responseProductSellingDtos = new ArrayList<>();
        List<SellingProduct> sellingProducts = new ArrayList<>();
        Set<Long> longSet = new HashSet<>();

        for (SellingProductDto sellingProductDto:sellingDto.getSellingProducts()){
            Product product = productRepo.findById(sellingProductDto.getProduct().getIdProduct())
                    .orElseThrow(()-> new NotFoundException("product",sellingProductDto.getProduct().getIdProduct()));

            //Verify that json contains a product once
            if (!longSet.add(product.getIdProduct())){
                throw new RepeatedException("product",product.getName());
            }

            //Verify stock
            if (product.getStock()<sellingProductDto.getQuantity()){
                throw new NotStockException("There is not stock for "+product.getName());
            }

            //Update Stock
            product.setStock(product.getStock()-sellingProductDto.getQuantity());

            //Calculate subtotal
            BigDecimal subtotal = product.getPrice().multiply(BigDecimal.valueOf(sellingProductDto.getQuantity())).setScale(2);

            ResponseProductSellingDto responseProductSellingDto = ResponseProductSellingDto.builder()
                    .idProduct(product.getIdProduct())
                    .product(product.getName())
                    .price(product.getPrice())
                    .quantity(sellingProductDto.getQuantity())
                    .subtotal(subtotal)
                    .build();

            responseProductSellingDtos.add(responseProductSellingDto);

            //Add subtotal to total
            total = total.add(subtotal);

            //Creando info de entidad de tabla intermedia, falta agregarle createdSelling
            SellingProduct sellingProduct = new SellingProduct();
            sellingProduct.setProduct(product);
            sellingProduct.setQuantity(sellingProductDto.getQuantity());
            sellingProduct.setSubtotal(subtotal);

            sellingProducts.add(sellingProduct);
        }

        Selling createdSelling = new Selling();
        createdSelling.setUser(user);
        createdSelling.setTotal(total);
        sellingRepo.save(createdSelling);

        for (SellingProduct sellingProduct:sellingProducts){
            sellingProduct.setSelling(createdSelling);
        }

        createdSelling.setSellingProducts(sellingProducts);
        Selling selling =  sellingRepo.save(createdSelling);

        ResponseSelling responseSelling = ResponseSelling.builder()
                .idSelling(selling.getIdSelling())
                .creationSelling(selling.getCreationSelling())
                .responseUserSellingDto(responseUserSellingDto)
                .total(total)
                .responseProductSellingDtos(responseProductSellingDtos)
                .build();

        return responseSelling;
    }





}
