package net.ahlam.costumerdataservice;

import net.ahlam.costumerdataservice.entities.customer;
import net.ahlam.costumerdataservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CostumerDataServiceApplication {

    public static void main(String[] args) {SpringApplication.run(CostumerDataServiceApplication.class, args);}


    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(customer.builder().name("ahlam").mail("ahlam@gmail.com").build());
            customerRepository.save(customer.builder().name("khawla").mail("khawla@gmail.com").build());
            customerRepository.save(customer.builder().name("kenza").mail("kenza@gmail.com").build());

        };
    }
}
