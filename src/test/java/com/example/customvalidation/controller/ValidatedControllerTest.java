package com.example.customvalidation.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.customvalidation.dto.ValidatedDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Disabled
class ValidatedControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @DisplayName("validatedDate_유효성 검증 성공_응답 코드:200")
  @Test
  void testValidatedDate() throws Exception {

    // Given & When
    String url = "/validated/date";
    ValidatedDto.Request validatedRequest = ValidatedDto.Request.builder()
        .title("title")
        .description("description")
        .completed(false)
        .createdDate("2022-06-06")
        .updateDate("2022-06-06")
        .build();

    ResultActions resultActions = mockMvc.perform(
        post(url)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(validatedRequest))
    );

    // Then
    resultActions
        .andExpect(status().isOk())
        .andDo(print());
  }

  @DisplayName("validatedDate_유효성 검증 실패_응답 코드:400")
  @Test
  void testValidatedDateFail() throws Exception {

    // Given & When
    String url = "/validated/date";
    ValidatedDto.Request validatedRequest = ValidatedDto.Request.builder()
        .title("title")
        .description("description")
        .completed(false)
        .createdDate("20220606")
        .updateDate("20220606")
        .build();

    ResultActions resultActions = mockMvc.perform(
        post(url)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(validatedRequest))
    );

    // Then
    resultActions
        .andExpect(status().isBadRequest())
        .andDo(print());
  }
}