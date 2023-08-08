package com.robotpal.robotservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Decimal128;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PositionResponse {
    private String id;
    private String name;
    private BigDecimal X;
    private BigDecimal Y;
    private BigDecimal Z;
    private BigDecimal Rx;
    private BigDecimal Ry;
    private BigDecimal Rz;
}

