package com.robotpal.robotservice.service;

import com.robotpal.robotservice.dto.PositionRequest;
import com.robotpal.robotservice.dto.PositionResponse;
import com.robotpal.robotservice.model.Position;
import com.robotpal.robotservice.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PositionService {

    private final PositionRepository positionRepository;

    public void createPosition(PositionRequest positionRequest){
        Position position = Position.builder()
                .name(positionRequest.getName())
                .X(positionRequest.getX())
                .Y(positionRequest.getY())
                .Z(positionRequest.getZ())
                .Rx(positionRequest.getRx())
                .Ry(positionRequest.getRy())
                .Rz(positionRequest.getRz())
                .build();

        positionRepository.save(position);
        log.info("{}'s position {} is saved", position.getName(), position.getId());

    }

    public List<PositionResponse> getAllPositions() {
        List<Position> positions =  positionRepository.findAll();
        return positions.stream().map(this::mapToPositionResponse).toList();
    }

    private PositionResponse mapToPositionResponse(Position position) {
        return PositionResponse.builder()
                .id(position.getId())
                .name(position.getName())
                .X(position.getX())
                .Y(position.getY())
                .Z(position.getZ())
                .Rx(position.getRx())
                .Ry(position.getRy())
                .Rz(position.getRz())
                .build();

    }
}
