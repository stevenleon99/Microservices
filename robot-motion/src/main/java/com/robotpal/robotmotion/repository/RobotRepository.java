package com.robotpal.robotmotion.repository;

import com.robotpal.robotmotion.model.Robot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RobotRepository extends JpaRepository<Robot, Long> {
}
