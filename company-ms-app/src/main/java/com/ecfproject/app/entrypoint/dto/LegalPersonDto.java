package com.ecfproject.app.entrypoint.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Getter
public class LegalPersonDto {

  private final String name;

}
