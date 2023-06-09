package net.ahlam.costumerdataservice.web;

import io.grpc.stub.StreamObserver;
import net.ahlam.costumerdataservice.entities.customer;
import net.ahlam.costumerdataservice.mapper.CustomerMapper;
import net.ahlam.costumerdataservice.repository.CustomerRepository;
import net.ahlam.costumerdataservice.stub.CustomerServiceGrpc;
import net.ahlam.costumerdataservice.stub.CustomerServiceOuterClass;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@GrpcService
public class CustomerGrpc extends CustomerServiceGrpc.CustomerServiceImplBase {
    @Autowired
    private CustomerMapper customerMapper;
    private CustomerRepository customerRepository;
    @Override
    public void getAllCustomers(CustomerServiceOuterClass.GetAllCustomerRequest request, StreamObserver<CustomerServiceOuterClass.GetAllCustomerResponse> responseObserver) {
        List<customer>customerList= customerRepository.findAll();
       List<CustomerServiceOuterClass.Customer> grpcCustomers= customerList.stream().map(customerMapper::fromCustomer).collect(Collectors.toList());
        CustomerServiceOuterClass.GetAllCustomerResponse customerResponse= CustomerServiceOuterClass.GetAllCustomerResponse.newBuilder()
                .addAllCustomers(grpcCustomers)
                .build();
      responseObserver.onNext(customerResponse);
      responseObserver.onCompleted();
    }

    @Override
    public void getCustomerById(CustomerServiceOuterClass.GetCustomerByIdRequest request, StreamObserver<CustomerServiceOuterClass.GetCustomerByIdResponse> responseObserver) {
        customer customerEntity=customerRepository.findById(request.getCustomerId()).get();
        CustomerServiceOuterClass.GetCustomerByIdResponse response=
                CustomerServiceOuterClass.GetCustomerByIdResponse.newBuilder()
                        .setCustomer(customerMapper.fromCustomer(customerEntity))
                        .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void saveCustomer(CustomerServiceOuterClass.saveCustomerRequest request, StreamObserver<CustomerServiceOuterClass.saveCustomerResponse> responseObserver) {
        customer c=customerMapper.fromGrpcCustomerRequest(request.getCustomer());
        customer savedCustomer = customerRepository.save(c);
        CustomerServiceOuterClass.saveCustomerResponse response=
        CustomerServiceOuterClass.saveCustomerResponse.newBuilder()
                .setCustomer(customerMapper.fromCustomer(savedCustomer))
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
