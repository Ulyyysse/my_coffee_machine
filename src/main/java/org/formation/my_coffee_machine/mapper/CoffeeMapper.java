package org.formation.my_coffee_machine.mapper;

import org.formation.my_coffee_machine.dto.CoffeeDto;
import org.formation.my_coffee_machine.entity.Coffee;
import org.formation.my_coffee_machine.dto.CoffeeCreateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CoffeeMapper {
    CoffeeDto toDto(Coffee coffee);

    @Mapping(target = "id", ignore = true)
    Coffee toEntity(CoffeeCreateDto dto);
}
