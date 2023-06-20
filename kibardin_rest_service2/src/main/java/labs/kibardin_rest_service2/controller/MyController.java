package labs.kibardin_rest_service2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import labs.kibardin_rest_service2.model.Request;
import labs.kibardin_rest_service2.model.Response;
import labs.kibardin_rest_service2.service.MyModifyService;

@Slf4j
@RestController
public class MyController {

    private final MyModifyService myModifyService;

    @Autowired
    public MyController (@Qualifier("ModifyErrorMessage") MyModifyService myModifyService){
        this.myModifyService=myModifyService;
    }

    @PostMapping(value = "/send")
    public ResponseEntity<Response> send(@RequestBody Request request){

        log.info("Входящий запрос : " + String.valueOf(request));

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(request.getSystemTime())
                .code("success")
                .errorCode("")
                .errorMessage("")
                .build();

        log.info("Исходящий запрос : " + String.valueOf(response));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}