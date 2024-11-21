package com.catdog.comerce.controller;

import com.catdog.comerce.dto.GenericResponse;
import com.catdog.comerce.dto.request.BrandDto;
import com.catdog.comerce.dto.response.ResponseBrandDto;
import com.catdog.comerce.service.IBrandService;
import com.catdog.comerce.utils.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/brand")
@RequiredArgsConstructor
public class BrandController {
    private final MapperUtil mapperUtil;
    private final IBrandService brandService;


    @GetMapping
    public ResponseEntity<GenericResponse<ResponseBrandDto>> findAllBrands(){
        List<ResponseBrandDto> responseBrandDtos = mapperUtil.mapList(brandService.findAll(), ResponseBrandDto.class);
        return new ResponseEntity<>(new GenericResponse<>(200,"success", responseBrandDtos), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<ResponseBrandDto>> findBrand(@PathVariable Long id){
        ResponseBrandDto responseBrandDto = mapperUtil.map(brandService.getById(id), ResponseBrandDto.class);

        return new ResponseEntity<>(new GenericResponse<>(200,"success", Arrays.asList(responseBrandDto)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenericResponse<ResponseBrandDto>> createBrand(@RequestBody @Valid BrandDto brandDto){
        ResponseBrandDto responseBrandDto = mapperUtil.map(brandService.create(brandDto),ResponseBrandDto.class);

        return new ResponseEntity<>(new GenericResponse<>(201,"success",Arrays.asList(responseBrandDto)),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long id){
        brandService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<ResponseBrandDto>> updateBrand(@RequestBody @Valid BrandDto brandDto,@PathVariable Long id){
        ResponseBrandDto responseBrandDto = mapperUtil.map(brandService.update(brandDto,id), ResponseBrandDto.class);
        return new ResponseEntity<>(new GenericResponse<ResponseBrandDto>(200,"success",Arrays.asList(responseBrandDto)),HttpStatus.OK);
    }







}
