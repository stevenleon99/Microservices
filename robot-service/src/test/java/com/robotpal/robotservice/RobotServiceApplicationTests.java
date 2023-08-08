package com.robotpal.robotservice;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.robotpal.robotservice.dto.PositionRequest;
import com.robotpal.robotservice.repository.PositionRepository;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.swing.*;
import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class RobotServiceApplicationTests {


	@Container
	private static final MongoDBContainer mongoDbContainer = new MongoDBContainer("mongo:6.0.8");
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private PositionRepository positionRepository;

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
		dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDbContainer::getReplicaSetUrl);

	}

	@Test
	void printResult(){
		System.out.print("The test starts");
	}

	@Test
	void shouldCreatePosition() throws Exception {
		PositionRequest positionRequest = getPositionRequest();
		String positionRequestString = objectMapper.writeValueAsString(positionRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/position")
					.contentType(MediaType.APPLICATION_JSON)
					.content(positionRequestString))
				.andExpect(status().isCreated());
		Assertions.assertEquals(1, positionRepository.findAll().size());

	}

	private PositionRequest getPositionRequest(){
		return PositionRequest.builder()
				.name("Kuka")
				.x(BigDecimal.valueOf(10.0))
				.y(BigDecimal.valueOf(10.0))
				.z(BigDecimal.valueOf(10))
				.rx(BigDecimal.valueOf(90))
				.ry(BigDecimal.valueOf(90))
				.rz(BigDecimal.valueOf(90))
				.build();

	}

}
