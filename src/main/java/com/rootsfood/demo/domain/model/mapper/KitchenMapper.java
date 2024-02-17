package com.rootsfood.demo.domain.model.mapper;

import com.rootsfood.demo.domain.model.dto.KitchenDTO;
import com.rootsfood.demo.domain.model.entity.Kitchen;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface KitchenMapper {

    @Mapping(target = "id", ignore = true)
    Kitchen toEntity(@MappingTarget Kitchen entity, KitchenDTO dto);

    Kitchen toEntity(KitchenDTO dto);

    KitchenDTO toDTO(Kitchen entity);

    List<KitchenDTO> toDTO(List<Kitchen> entity);

}
