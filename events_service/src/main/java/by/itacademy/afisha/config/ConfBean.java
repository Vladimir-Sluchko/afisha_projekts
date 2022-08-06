package by.itacademy.afisha.config;

import by.itacademy.afisha.service.utils.ClassifierClient;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfBean {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public ClassifierClient checkUuid(RestTemplate restTemplate){
        return new ClassifierClient(restTemplate);
    }

}
