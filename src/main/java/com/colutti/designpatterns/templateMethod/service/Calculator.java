package com.colutti.designpatterns.templateMethod.service;

import com.colutti.designpatterns.templateMethod.dto.Budget;

import java.math.BigDecimal;

public interface Calculator {

    BigDecimal calculateDiscount(Budget budget);

}
