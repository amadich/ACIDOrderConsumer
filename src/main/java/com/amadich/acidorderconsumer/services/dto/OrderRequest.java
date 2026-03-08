package com.amadich.acidorderconsumer.services.dto;

import lombok.Data;

@Data
public class OrderRequest {
    private Long productId;
    private Long userId;
}
