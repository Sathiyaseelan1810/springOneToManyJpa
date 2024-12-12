package com.mapping.onetomany.jpa.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "PRODUCT_DETAILS")
public class ProductDetails {

    @Id
    private Integer productId;
    private String productName;
    private Integer productQty;
    private String productTotalPrice;



}
