package com.rodrigo.picpay.domain.entity;

import com.rodrigo.picpay.domain.enums.UserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "TBL_USER")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @CPF(message = "CPF inválido.")
    @NotEmpty(message = "Campo CPF obrigatório.")
    @Column(unique = true)
    private String document;

    @NotEmpty(message = "Campo email obrigatório.")
    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated
    private UserType userType;

}
