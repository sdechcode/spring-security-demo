package com.sdechcode.springsecuritydemo.dto.khmerlang;

import com.fasterxml.jackson.annotation.JsonProperty;

public record KhmerLangRequestDto(
        String text,
        @JsonProperty("is_short_word")
        Boolean isShortWord
) {
}
