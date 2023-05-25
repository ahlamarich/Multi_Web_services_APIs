package net.ahlam.costumerdataservice.web;

import lombok.AllArgsConstructor;
import net.ahlam.costumerdataservice.entities.customer;
import net.ahlam.costumerdataservice.repository.CustomerRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class CustomerGraphql {
    private CustomerRepository customerRepository;

    @QueryMapping
    public List<customer> Allcustomers(){
        return customerRepository.findAll();
    }

    @QueryMapping
    public customer customerById(@Argument Long id){
        customer customer= customerRepository.findById(id).orElse(null);
        if (customer==null) throw  new RuntimeException(String.format("Customer %s not found",id));
        return customer;
    }
    @MutationMapping
    public customer saveCustomers(customer Request){
        return customerRepository.save(Request);
    }
}
