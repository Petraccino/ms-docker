package it.petraccino.hrpayroll.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Worker implements Serializable {

    private Long id;
    private String name;
    private Double dailyIncome;
}
