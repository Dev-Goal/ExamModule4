package com.codegym.discountcode.service;

import com.codegym.discountcode.dto.PromotionDto;
import com.codegym.discountcode.entity.Promotion;

import java.util.List;
import java.util.Optional;

public interface PromotionService {
    List<PromotionDto> getAllPromotions();

    Promotion savePromotion(Promotion promotion);

    void deletePromotionById(Long id);

    Optional<PromotionDto> getPromotionById(Long id);
}
