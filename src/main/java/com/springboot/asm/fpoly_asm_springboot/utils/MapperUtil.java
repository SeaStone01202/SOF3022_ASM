package com.springboot.asm.fpoly_asm_springboot.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MapperUtil {

    private static final ModelMapper modelMapper;
    private static final ObjectMapper OBJECT_MAPPER;

    static {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        OBJECT_MAPPER = new ObjectMapper();
    }

    private MapperUtil() {
    }

    public static <D, T> D map(final T entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }// đưa vào đối tượng T và class D ==> Đối tượng D

    public static <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
        return entityList.stream()
                .map(entity -> map(entity, outCLass))
                .collect(Collectors.toList());
    }// đưa vào một list T và class D ==> list D đã được map

    public static <D, T> Page<D> mapEntityPageIntoDtoPage(final Page<T> entities, Class<D> dtoClass) {
        return entities.map(objectEntity -> modelMapper.map(objectEntity, dtoClass));
    }

}
