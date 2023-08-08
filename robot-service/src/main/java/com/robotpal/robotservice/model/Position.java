package com.robotpal.robotservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Decimal128;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;


@Document(value = "position")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    @Id
    private String id;

    private String name;
    private BigDecimal X;
    private BigDecimal Y;
    private BigDecimal Z;
    private BigDecimal Rx;
    private BigDecimal Ry;
    private BigDecimal Rz;
}
