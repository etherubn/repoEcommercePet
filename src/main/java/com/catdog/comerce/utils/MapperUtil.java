package com.catdog.comerce.utils;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MapperUtil {
    private final ModelMapper modelMapper;

    public <S,T> List<T> mapList(List<S> source,Class<T> target){
        return source.stream().map(element-> modelMapper.map(element,target))
                .toList();
    }

    public <S,T> T map(S source,Class<T> target){
        return modelMapper.map(source,target);
    }
}
