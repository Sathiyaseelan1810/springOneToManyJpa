package com.mapping.onetomany.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CustomResponse {

    private String firstName;

    private String lastName;

    private String productName;

    private String productTotalPrice;

    private Integer productQty;
}
