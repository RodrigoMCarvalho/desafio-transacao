package com.rodrigo.picpay.mapper;

import com.rodrigo.picpay.domain.dto.BalanceRequest;
import com.rodrigo.picpay.domain.entity.Balance;
import com.rodrigo.picpay.domain.entity.User;
import com.rodrigo.picpay.domain.dto.UserRequest;
import com.rodrigo.picpay.domain.dto.UserResponse;
import com.rodrigo.picpay.domain.enums.UserType;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@UtilityClass
public class UserMapper {

    public static List<UserResponse> toListUserResponse(List<User> users) {
        return users.stream().map(UserMapper::toUserResponse).toList();
    }

    public static UserResponse toUserResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getDocument(),
                user.getEmail(), user.getUserType(),
                user.getBalance().getValue());
    }

    public static User toUser(UserRequest request) {
        return User.builder()
                .name(request.name())
                .email(request.email())
                .document(request.document())
                .balance(toBalance(Optional.ofNullable(request.balance()).orElse(new BalanceRequest(BigDecimal.ZERO))))
                .userType(UserType.getUserType(request.userType()))
                .build();
    }

    public static Balance toBalance(BalanceRequest request) {
        return Balance.builder().value(request.value()).build();
    }
}
