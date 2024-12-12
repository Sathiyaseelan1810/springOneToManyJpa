package com.mapping.onetomany.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String emailId;
    private List<ProductDto> productDto;
}
