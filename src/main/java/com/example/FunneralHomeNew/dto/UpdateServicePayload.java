package com.example.FunneralHomeNew.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateServicePayload(
        @NotBlank(message = "Название услуги не может быть пустым")
        String title,
        @NotNull(message = "Поле цены не может быть пустым ")
        Integer price
) {
}
