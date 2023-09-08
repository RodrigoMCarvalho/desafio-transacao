package com.rodrigo.picpay.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "TBL_BALANCE")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "balance" )
    private User user;

    @Column(name = "value")
    private BigDecimal value;
}
