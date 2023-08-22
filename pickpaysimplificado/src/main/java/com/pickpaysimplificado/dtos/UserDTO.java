package com.pickpaysimplificado.dtos;

import com.pickpaysimplificado.domain.user.UserType;

import java.math.BigDecimal;

public record UserDTO(String firstName, String lastName, String Document, BigDecimal balance, String name, String password, UserType userType) {
}
