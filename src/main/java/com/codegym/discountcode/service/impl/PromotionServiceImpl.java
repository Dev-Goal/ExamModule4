package com.codegym.discountcode.service.impl;

import com.codegym.discountcode.dto.PromotionDto;
import com.codegym.discountcode.entity.Promotion;
import com.codegym.discountcode.repository.PromotionRepository;
import com.codegym.discountcode.service.PromotionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PromotionServiceImpl implements PromotionService {
    private final PromotionRepository promotionRepository;

    @Override
    public List<PromotionDto> getAllPromotions() {
        return promotionRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Promotion savePromotion(Promotion promotion) {
        return promotionRepository.save(promotion);
    }


    private PromotionDto convertToDTO(Promotion promotion) {
        return new PromotionDto(promotion.getTitle(),
                promotion.getStartTime(), promotion.getEndTime(),
                promotion.getDiscount(), promotion.getDetails());
    }

    @Override
    public void deletePromotionById(Long id) {
        promotionRepository.deleteById(id);
    }


    @Override
    public Optional<PromotionDto> getPromotionById(Long id) {
        return promotionRepository.findById(id).map(this::convertToDTO);
    }
}
