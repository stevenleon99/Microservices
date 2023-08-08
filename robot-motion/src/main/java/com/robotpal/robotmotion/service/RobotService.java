package com.robotpal.robotmotion.service;

import com.robotpal.robotmotion.dto.OperateItemsDto;
import com.robotpal.robotmotion.dto.OperationRequest;
import com.robotpal.robotmotion.model.OperateItems;
import com.robotpal.robotmotion.model.Robot;
import com.robotpal.robotmotion.repository.RobotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RobotService {

    private final RobotRepository robotRepository;
    public void createRobotMotion(OperationRequest operationRequest){
        Robot robot = new Robot();
        robot.setRobotName(operationRequest.getRobotName());

        List<OperateItems> operateItemsList = operationRequest.getOperateItemsList()
                .stream()
                .map(this::mapToOperateItems)
                .toList();

        robot.setOperateItemsList(operateItemsList);

        robotRepository.save(robot);

    }

    private OperateItems mapToOperateItems(OperateItemsDto operateItemsDto) {
        OperateItems operateItems = new OperateItems();
        operateItems.setQuantity(operateItemsDto.getQuantity());
        operateItems.setOperationType(operateItemsDto.getOperationType());
        return operateItems;
    }

}
