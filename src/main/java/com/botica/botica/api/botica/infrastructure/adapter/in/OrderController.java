package com.botica.botica.api.botica.infrastructure.adapter.in;

import com.botica.botica.api.botica.application.port.in.CreateOrderCommand;
import com.botica.botica.api.botica.application.port.in.CreateOrderUseCase;
import com.botica.botica.api.botica.application.port.in.GetOrderUseCase;
import com.botica.botica.api.botica.domain.model.Order;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final CreateOrderUseCase createOrderUseCase;
    private final GetOrderUseCase getOrderUseCase;

    public OrderController(CreateOrderUseCase createOrderUseCase, GetOrderUseCase getOrderUseCase){
        this.createOrderUseCase = createOrderUseCase;
        this.getOrderUseCase = getOrderUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponseDto create(@Valid @RequestBody OrderRequestDto orderRequestDto){
        CreateOrderCommand orderCommand = OrderWebMapper.toCommand(orderRequestDto);
        Order orderSaved = createOrderUseCase.create(orderCommand);
        return OrderWebMapper.toResponseDto(orderSaved);
    }

    @GetMapping
    public List<OrderResponseDto> findAll(){
        return OrderWebMapper.toListResponse(getOrderUseCase.findAll());

    }

    @GetMapping("/{id}")
    public OrderResponseDto findById(@PathVariable Long id){
        return OrderWebMapper.toResponseDto(getOrderUseCase.findById(id));
    }




}
