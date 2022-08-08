package by.itacademy.afisha.service.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;
@Component
public class ClassifierClient {

    private final RestTemplate restTemplate;


    @Value("${url.urlClassifierCountry}")
    private String urlClassifierCountry;

    @Value("${url.urlClassifierCategory}")
    private String urlClassifierCategory;


    public ClassifierClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public boolean isCheckUuidCountry(UUID uuid){
        String url = this.urlClassifierCountry;
        ResponseEntity<Object> forEntity = restTemplate.getForEntity(url + uuid, Object.class);
        HttpStatus statusCode = forEntity.getStatusCode();
        if(statusCode == HttpStatus.OK){
            return true;
        } else {
            return false;
        }
    }
    public boolean isCheckUuidCategory(UUID uuid){
        String url = this.urlClassifierCategory;
        ResponseEntity<Object> forEntity = restTemplate.getForEntity(url + uuid, Object.class);
        HttpStatus statusCode = forEntity.getStatusCode();
        if(statusCode == HttpStatus.OK){
            return true;
        } else {
            return false;
        }
    }


}
