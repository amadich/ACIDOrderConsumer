package com.amadich.acidorderconsumer.services;

import com.amadich.acidorderconsumer.entitiy.Product;
import com.amadich.acidorderconsumer.repository.ProductRepository;
import com.amadich.acidorderconsumer.services.dto.OrderRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrderConsumer {

    private final ProductRepository productRepository;

    @RabbitListener(queues = "orderQueue")
    @Transactional
    public void processOrder(OrderRequest request){

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow();

        product.decreaseStock();

        productRepository.save(product);

        System.out.println("Order created for user " + request.getUserId());
    }

}
