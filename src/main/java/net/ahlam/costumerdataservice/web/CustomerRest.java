package net.ahlam.costumerdataservice.web;


import lombok.AllArgsConstructor;
import net.ahlam.costumerdataservice.entities.customer;
import net.ahlam.costumerdataservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerRest {
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<customer> CustomerList(){
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public customer CustomerById(@PathVariable Long id){
        return customerRepository.findById(id).get();
    }

    @PostMapping("/customers")
    public customer saveCustomer(@RequestBody customer customer){
        return customerRepository.save(customer);
    }





}
