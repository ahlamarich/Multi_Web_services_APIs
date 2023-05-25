package net.ahlam.costumerdataservice.web;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;
import net.ahlam.costumerdataservice.dto.CustomerRequest;
import net.ahlam.costumerdataservice.entities.customer;
import net.ahlam.costumerdataservice.mapper.CustomerMapper;
import net.ahlam.costumerdataservice.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@WebService
public class CustomerSoap {
    private CustomerRepository customerRepository;
   private CustomerMapper customerMapper;

    @WebMethod
    public List<customer> customerList(){
        return customerRepository.findAll();
    }
    @WebMethod
    public customer customerById(@WebParam(name = "id") Long id){
        return customerRepository.findById(id).get();
    }

    @WebMethod
    public customer savecustomer(@WebParam CustomerRequest customerRequest){

       return customerMapper.from(customerRequest);
    }
}

