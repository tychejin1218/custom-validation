package com.example.customvalidation.dto;

import com.example.customvalidation.annotiaon.DateValid;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class ValidatedDto {

  @Getter
  @Setter
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  @ToString
  public static class Request {

    @JsonProperty("id")
    private Long id;

    @NotBlank
    @JsonProperty("title")
    private String title;

    @NotBlank
    @JsonProperty("description")
    private String description;

    @AssertFalse
    @JsonProperty("completed")
    private Boolean completed;

    @DateValid(message = "8자리의 yyyy-MM-dd 형식이어야 합니다.", pattern = "yyyy-MM-dd")
    @JsonProperty("created_date")
    private String createdDate;

    @DateValid(message = "8자리의 yyyy-MM-dd 형식이어야 합니다.", pattern = "yyyy-MM-dd")
    @JsonProperty("updated_date")
    private String updateDate;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  @ToString
  public class Response {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("title")
    private String titile;

    @JsonProperty("description")
    private String description;

    @JsonProperty("completed")
    private Boolean completed;

    @JsonProperty("created_date")
    private String createdDate;

    @JsonProperty("updated_date")
    private String updateDate;
  }
}
