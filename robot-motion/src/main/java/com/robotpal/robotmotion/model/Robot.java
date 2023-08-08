package com.robotpal.robotmotion.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_robot")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Robot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String robotName;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OperateItems> operateItemsList;



}
