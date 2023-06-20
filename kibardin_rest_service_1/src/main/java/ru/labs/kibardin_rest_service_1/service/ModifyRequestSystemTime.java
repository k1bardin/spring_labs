package ru.labs.kibardin_rest_service_1.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.labs.kibardin_rest_service_1.model.Request;

@Service
public class ModifyRequestSystemTime implements ModifyRequestService {
    @Override
    public void modifyRq (Request request){

        request.setSystemTime("test");

        HttpEntity<Request> httpEntity = new  HttpEntity<>(request);

        new RestTemplate().exchange("http://localhost:8082/send",
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<>() {
                });
    }
}
