package com.ecfproject.app.entrypoint.rest;

import com.ecfproject.app.entrypoint.configuration.PathConfig;
import com.ecfproject.app.entrypoint.dto.LegalPersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("${app.controller.path.legalPerson}")
@RequiredArgsConstructor
public class LegalPersonController {

  private final PathConfig pathConfig;

  @GetMapping
  public ResponseEntity<String> findAll() {
    return ResponseEntity.ok(pathConfig.getLegalPerson());
  }

  @PostMapping(consumes = APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> create(
    final LegalPersonDto legalPerson,
    final UriComponentsBuilder uriComponentsBuilder) {

    final var location = uriComponentsBuilder
      .path(pathConfig.getLegalPerson())
      .buildAndExpand(1)
      .toUri();

    return ResponseEntity.created(location).build();
  }
}
