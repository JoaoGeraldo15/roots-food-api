package com.rootsfood.demo.web;

import com.rootsfood.demo.domain.model.dto.KitchenDTO;
import com.rootsfood.demo.domain.service.KitchenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/kitchen")
public class KitchenResource {

    private KitchenService service;

    @PostMapping
    public ResponseEntity<KitchenDTO> create(@RequestBody KitchenDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<KitchenDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<KitchenDTO>> findById() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<KitchenDTO> update(@PathVariable Long id, @RequestBody KitchenDTO dto) {
        return ResponseEntity.ok().body(service.update(id, dto));
    }
}
