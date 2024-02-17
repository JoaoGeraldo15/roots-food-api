package com.rootsfood.demo.domain.service.impl;

import com.rootsfood.demo.domain.model.dto.KitchenDTO;
import com.rootsfood.demo.domain.model.entity.Kitchen;
import com.rootsfood.demo.domain.model.mapper.KitchenMapper;
import com.rootsfood.demo.domain.repository.KitchenRepository;
import com.rootsfood.demo.domain.service.KitchenService;
import com.rootsfood.demo.domain.service.excepetion.EntityInUseExeception;
import com.rootsfood.demo.domain.service.excepetion.KitchenNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KitchenServiceImpl implements KitchenService {

    private static final String KITCHEN = "Kitchen";

    private final KitchenRepository repository;
    private final KitchenMapper mapper;

    @Override
    public List<KitchenDTO> findAll() {
        return mapper.toDTO(repository.findAll());
    }

    @Override
    public KitchenDTO findById(Long id) {
        return mapper.toDTO(findOrThrow(id));
    }

    @Override
    public KitchenDTO create(KitchenDTO dto) {
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public KitchenDTO update(Long id, KitchenDTO dto) {
        Kitchen currentKitchen = findOrThrow(id);
        Kitchen updatedKitchen = mapper.toEntity(currentKitchen, dto);
        return mapper.toDTO(repository.save(updatedKitchen));
    }

    @Override
    public void delete(Long id) {
        Kitchen kitchen = findOrThrow(id);

        try {
            repository.delete(kitchen);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseExeception(KITCHEN, id);
        }
    }

    private Kitchen findOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new KitchenNotFoundException(id));
    }
}
