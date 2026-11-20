package org.formation.my_coffee_machine.dto;

import jakarta.validation.constraints.Positive;

public record CoffeeUpdateDto(
        String name,
        // Integer permet d'avoir un null si on ne renseigne pas de prix
        @Positive(message = "Price should be positive")
        Integer price) {
}
