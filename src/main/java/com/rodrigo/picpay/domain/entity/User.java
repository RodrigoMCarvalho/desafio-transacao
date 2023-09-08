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
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @CPF(message = "CPF inválido.")
    @NotEmpty(message = "Campo CPF obrigatório.")
    @Column(name = "document", unique = true)
    private String document;

    @NotEmpty(message = "Campo email obrigatório.")
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "balance_id", referencedColumnName = "id")
    private Balance balance;


}
