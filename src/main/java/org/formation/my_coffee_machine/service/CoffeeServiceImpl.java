package org.formation.my_coffee_machine.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.formation.my_coffee_machine.dto.CoffeeCreateDto;
import org.formation.my_coffee_machine.dto.CoffeeDto;
import org.formation.my_coffee_machine.dto.CoffeeUpdateDto;
import org.formation.my_coffee_machine.entity.Coffee;
import org.formation.my_coffee_machine.mapper.CoffeeMapper;
import org.formation.my_coffee_machine.repository.CoffeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeRepository repository;
    private final CoffeeMapper mapper;

    @PostConstruct
    void initDb() {
        repository.saveAll(List.of(
                        new Coffee("Espresso", 98),
                        new Coffee("Latte", 76),
                        new Coffee("Robusta", 54)
                )
        );
    }

    @Override
    public List<CoffeeDto> allCoffees() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public Optional<CoffeeDto> oneCoffee(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    @Override
    public CoffeeDto create(CoffeeCreateDto dto) {
        Coffee entity = mapper.toEntity(dto);
        Coffee saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    @Transactional
    public Optional<CoffeeDto> update(Long id, CoffeeUpdateDto dto) {
        return repository.findById(id).map(existing -> {
            mapper.updateEntity(existing, dto);
            return mapper.toDto(existing);
        });
    }
}
