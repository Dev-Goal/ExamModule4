package com.codegym.discountcode.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PromotionDto {
    private Long id;

    private String title;

    private Date startTime;

    private Date endTime;

    private double discount;

    private String details;

    public PromotionDto() {
    }

    public PromotionDto(String title, Date startTime, Date endTime, double discount, String details) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.discount = discount;
        this.details = details;
    }
}
