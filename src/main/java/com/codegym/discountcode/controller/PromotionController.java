package com.codegym.discountcode.controller;

import com.codegym.discountcode.dto.PromotionDto;
import com.codegym.discountcode.entity.Promotion;
import com.codegym.discountcode.service.PromotionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/promotions")
@AllArgsConstructor
public class PromotionController {
    private final PromotionService promotionService;

    @GetMapping
    public String showPromotions(Model model) {
        List<PromotionDto> promotions = promotionService.getAllPromotions();
        model.addAttribute("promotions", promotions);
        return "list";
    }

    @GetMapping("/create")
    public ModelAndView showCreatePromotionForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("promotion", new PromotionDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public String createPromotion(@ModelAttribute("promotion") PromotionDto promotion) {
        Promotion promotion1 = new Promotion();
        BeanUtils.copyProperties(promotion, promotion1);
        promotionService.savePromotion(promotion1);
        return "redirect:/promotions";
    }

    @GetMapping("{id}/delete")
    public String deletePromotion(@PathVariable Long id) {
        Optional<PromotionDto> promotion = promotionService.getPromotionById(id);
        promotion.ifPresent(promotionDto -> promotionService.deletePromotionById(promotionDto.getId()));
        return "redirect:/promotions";
    }
}
