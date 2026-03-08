package com.amadich.acidorderconsumer.controller;

import com.amadich.acidorderconsumer.services.dto.OrderRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final RabbitTemplate rabbitTemplate;
    private final RedisTemplate<String,Object> redisTemplate;

    public OrderController(RabbitTemplate rabbitTemplate,
                           RedisTemplate<String,Object> redisTemplate){
        this.rabbitTemplate = rabbitTemplate;
        this.redisTemplate = redisTemplate;
    }

    @PostMapping("/buy")
    public String buy(@RequestBody OrderRequest request){

        String lockKey = "lock:product:" + request.getProductId();

        Boolean locked = redisTemplate.opsForValue()
                .setIfAbsent(lockKey,"1",10, TimeUnit.SECONDS);

        if(Boolean.FALSE.equals(locked)){
            return "System busy try again";
        }

        rabbitTemplate.convertAndSend("orderQueue", request);

        return "Order processing";
    }

}
