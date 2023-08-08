package com.robotpal.robotservice.controller;

import com.robotpal.robotservice.dto.PositionRequest;
import com.robotpal.robotservice.dto.PositionResponse;
import com.robotpal.robotservice.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/position")
@RequiredArgsConstructor
public class PositionController {

    private final PositionService positionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPosition(@RequestBody PositionRequest productRequest){
        positionService.createPosition(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PositionResponse> getAllPositions(){
        return positionService.getAllPositions();
    }
}
