package org.formation.my_coffee_machine.service;

import org.formation.my_coffee_machine.dto.CoffeeCreateDto;
import org.formation.my_coffee_machine.dto.CoffeeDto;

import java.util.List;
import java.util.Optional;

public interface CoffeeService {
    List<CoffeeDto> allCoffees();
    Optional<CoffeeDto> oneCoffee(Long id);
    CoffeeDto create(CoffeeCreateDto dto);
    // update
}
