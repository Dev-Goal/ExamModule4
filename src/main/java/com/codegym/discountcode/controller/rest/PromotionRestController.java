package com.codegym.discountcode.controller.rest;

import com.codegym.discountcode.dto.PromotionDto;
import com.codegym.discountcode.service.PromotionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/promotions")
@CrossOrigin
@AllArgsConstructor
public class PromotionRestController {
    private final PromotionService promotionService;

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        Optional<PromotionDto> promotionDto = promotionService.getPromotionById(id);
        if (promotionDto.isPresent()) {
            promotionService.deletePromotionById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
