package org.formation.my_coffee_machine.mapper;

import org.formation.my_coffee_machine.dto.CoffeeDto;
import org.formation.my_coffee_machine.dto.CoffeeUpdateDto;
import org.formation.my_coffee_machine.entity.Coffee;
import org.formation.my_coffee_machine.dto.CoffeeCreateDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CoffeeMapper {
    CoffeeDto toDto(Coffee coffee);

    @Mapping(target = "id", ignore = true)
    Coffee toEntity(CoffeeCreateDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget Coffee entity, CoffeeUpdateDto dto);
}
