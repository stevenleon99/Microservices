package com.robotpal.robotmotion.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "t_operate_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OperateItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    private String operationType;

}
