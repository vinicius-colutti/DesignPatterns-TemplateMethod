package com.colutti.designpatterns.templateMethod.controller;

import com.colutti.designpatterns.templateMethod.dto.Budget;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class BudgetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void mustReturn35DiscountWhenPass700ForValueAnd3ForQualityItems() throws Exception {
        Budget budget = new Budget(new BigDecimal(700),3);
        mockMvc.perform(post("/budget/")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(budget)))
                .andExpect(status().isOk())
                .andExpect(content().string("35.00"));
    }

    @Test
    public void mustReturnODiscountWhenPass100ForValueAnd3ForQualityItems() throws Exception {
        Budget budget = new Budget(new BigDecimal(100),3);
        mockMvc.perform(post("/budget/")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(budget)))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    public void mustReturn1ODiscountWhenPass100ForValueAnd7ForQualityItems() throws Exception {
        Budget budget = new Budget(new BigDecimal(100),7);
        mockMvc.perform(post("/budget/")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(budget)))
                .andExpect(status().isOk())
                .andExpect(content().string("10.0"));
    }

}
