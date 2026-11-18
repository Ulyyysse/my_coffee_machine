package org.formation.my_coffee_machine;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.formation.my_coffee_machine.dto.CoffeeCreateDto;
import org.formation.my_coffee_machine.dto.CoffeeDto;
import org.formation.my_coffee_machine.service.CoffeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("coffees")
@RequiredArgsConstructor
public class CoffeeController {

    private final CoffeeService service;

    @PostMapping
    CoffeeDto create(@RequestBody @Valid CoffeeCreateDto dto) {
        return service.create(dto);
    }

    @GetMapping
    List<CoffeeDto> coffees() {
        return service.allCoffees();
    }

    @GetMapping("{id}")
    ResponseEntity<CoffeeDto> coffee(@PathVariable Long id) {
        return service.oneCoffee(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
