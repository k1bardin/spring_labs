package ru.labs.kibardin_rest_service_1.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.labs.kibardin_rest_service_1.model.Request;
import ru.labs.kibardin_rest_service_1.model.Response;
import ru.labs.kibardin_rest_service_1.service.MyModifyService;
import ru.labs.kibardin_rest_service_1.service.ModifyRequestService;

@Slf4j
@RestController
public class MyController {

    private final MyModifyService myModifyService;
    private final ModifyRequestService modifyRequestService;

    @Autowired
    public MyController (@Qualifier("ModifySystemTime") MyModifyService myModifyService){
        this.myModifyService=myModifyService;
        this.modifyRequestService=modifyRequestService;
    }

    @PostMapping(value = "/send")
    public ResponseEntity<Response> send(@RequestBody Request request){

        log.warn("Входящий запрос : " + String.valueOf(request));

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(request.getSystemTime())
                .code("success")
                .errorCode("")
                .errorMessage("")
                .build();

        modifyRequestService.modifyRq(request);

        Response responseAfterModify = myModifyService.modify(response);

        log.warn("Исходящий запрос : " + String.valueOf(response));

        return new ResponseEntity<>(responseAfterModify, HttpStatus.OK);
    }
}

