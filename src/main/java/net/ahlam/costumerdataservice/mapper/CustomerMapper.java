package net.ahlam.costumerdataservice.mapper;

import net.ahlam.costumerdataservice.dto.CustomerRequest;
import net.ahlam.costumerdataservice.entities.customer;
import net.ahlam.costumerdataservice.stub.CustomerServiceOuterClass;
import net.ahlam.costumerdataservice.web.CustomerGrpc;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;
@Component
public class CustomerMapper {
private ModelMapper modelMapper=new ModelMapper();
    public customer from(CustomerRequest customerRequest){
      //customer customer=new customer();
      // customer.setName(customerRequest.name());
       //customer.setMail(customerRequest.mail());
      return modelMapper.map(customerRequest,customer.class);

    }
    public CustomerServiceOuterClass.Customer fromCustomer(customer customer){
        return modelMapper.map(customer, CustomerServiceOuterClass.Customer.Builder.class).build();
    }

    public customer fromGrpcCustomerRequest(CustomerServiceOuterClass.CustomerRequest customerRequest){
        return modelMapper.map(customerRequest, customer.class);
    }
}
