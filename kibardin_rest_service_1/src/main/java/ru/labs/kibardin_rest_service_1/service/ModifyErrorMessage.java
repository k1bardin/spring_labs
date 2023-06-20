package ru.labs.kibardin_rest_service_1.service;

import ru.labs.kibardin_rest_service_1.model.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier ("ModifyErrorMessage")

public class ModifyErrorMessage implements MyModifyService{

    @Override
    public Response modify (Response response){
        response.setErrorMessage("Случилась какая-то ошибка");
        return response;
    }
}
