package net.ahlam.costumerdataservice.repository;

import net.ahlam.costumerdataservice.entities.customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<customer,Long> {
}
