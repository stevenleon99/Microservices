package com.robotpal.robotmotion.controller;


import com.robotpal.robotmotion.dto.OperationRequest;
import com.robotpal.robotmotion.service.RobotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/moveRobot")
@RequiredArgsConstructor
@Slf4j
public class RobotController {

    private final RobotService robotService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String createRobotMotion(@RequestBody OperationRequest operationRequest){
        robotService.createRobotMotion(operationRequest);
        log.info("robot motions sent");
        return "Robot Motions Sent";
    }
}
