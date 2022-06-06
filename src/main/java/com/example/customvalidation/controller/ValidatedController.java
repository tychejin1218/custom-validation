package com.example.customvalidation.controller;

import com.example.customvalidation.dto.ValidatedDto;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ValidatedController {

  @PostMapping("/validated/date")
  public String validatedDate(
      @Valid @RequestBody ValidatedDto.Request validationRequest
  ) {
    log.info("validationRequest: {}", validationRequest);
    return "postValidation";
  }
}
