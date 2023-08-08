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
public class PositionRequest {
    private String name;
    private BigDecimal x;
    private BigDecimal y;
    private BigDecimal z;
    private BigDecimal rx;
    private BigDecimal ry;
    private BigDecimal rz;
}
