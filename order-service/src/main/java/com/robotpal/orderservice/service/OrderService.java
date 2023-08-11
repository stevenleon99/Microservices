package com.robotpal.orderservice.service;

import com.robotpal.orderservice.config.WebClientConfig;
import com.robotpal.orderservice.dto.InventoryResponse;
import com.robotpal.orderservice.dto.OrderLineItemsDto;
import com.robotpal.orderservice.dto.OrderRequest;
import com.robotpal.orderservice.model.Order;
import com.robotpal.orderservice.model.OrderLineItems;
import com.robotpal.orderservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    private final WebClient.Builder webClientBuilder;
    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItemsList =  orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemsList(orderLineItemsList);

        List<String> skuCodes = order.getOrderLineItemsList()
                .stream()
                .map(OrderLineItems::getSkuCode)
                .toList();

        //is in stock or not
        //by a synchronous request
        InventoryResponse[] inventoryResponsesArray  =  webClientBuilder.build().get()
                    .uri("http://inventory-service/api/inventory", uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                    .retrieve()
                    .bodyToMono(InventoryResponse[].class)
                    .block();

        boolean allInStock = Arrays.stream(inventoryResponsesArray)
                .allMatch(InventoryResponse::getIsInStock);

        if (allInStock) {
            orderRepository.save(order);
        }
        else {
            throw new IllegalArgumentException("Product not in Stock");
        }

    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
