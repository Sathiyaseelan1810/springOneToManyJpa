package com.mapping.onetomany.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Integer productId;
    private String productName;
    private Integer productQty;
    private String productTotalPrice;
}

