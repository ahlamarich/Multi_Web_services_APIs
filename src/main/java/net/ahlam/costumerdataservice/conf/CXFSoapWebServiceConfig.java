package net.ahlam.costumerdataservice.conf;

import lombok.AllArgsConstructor;
import net.ahlam.costumerdataservice.web.CustomerSoap;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class CXFSoapWebServiceConfig {
    @Autowired
    private Bus bus;
    @Autowired
    private CustomerSoap customerSoap;

    @Bean
    public EndpointImpl endpoint(){
        EndpointImpl endpoint=new EndpointImpl(bus,customerSoap);
        endpoint.publish("/CustomerService");
        return endpoint;
    }
}
