package org.formation.my_coffee_machine.repository;

import org.formation.my_coffee_machine.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

}
