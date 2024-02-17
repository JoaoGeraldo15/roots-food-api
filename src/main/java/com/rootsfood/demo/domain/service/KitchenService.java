package com.rootsfood.demo.domain.service;

import com.rootsfood.demo.domain.model.dto.KitchenDTO;

import java.util.List;

public interface KitchenService {

    List<KitchenDTO> findAll();

    KitchenDTO findById(Long id);

    KitchenDTO create(KitchenDTO dto);

    KitchenDTO update(Long id, KitchenDTO dto);

    void delete(Long id);
}
