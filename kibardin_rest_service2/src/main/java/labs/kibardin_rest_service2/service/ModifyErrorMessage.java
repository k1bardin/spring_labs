package labs.kibardin_rest_service2.service;

import labs.kibardin_rest_service2.model.Response;
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
