package com.mapping.onetomany.jpa.service.impl;

import com.mapping.onetomany.jpa.dao.CustomerDetails;
import com.mapping.onetomany.jpa.dao.ProductDetails;
import com.mapping.onetomany.jpa.dto.CustomerDto;
import com.mapping.onetomany.jpa.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class ObjectMapper {

    //DAO <- DTO
    // POST Request
    public CustomerDetails mapCustomerAccessFromTransfer(CustomerDto customerDto) {
        log.info("Mapping Individual Customer sent from DTO/users -> DAO");
        return CustomerDetails.builder()
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .mobileNumber(customerDto.getMobileNumber())
                .emailId(customerDto.getEmailId())
                .productDetails(mapProductAccessFromTransferList(customerDto.getProductDto()))
                .build();
    }

    private ProductDetails mapProductAccessFromTransfer(ProductDto productDto) {
        log.info("Mapping Individual Product for the customers sent from DTO/users -> DAO");
        return ProductDetails.builder()
                .productName(productDto.getProductName())
                .productId(productDto.getProductId())
                .productQty(productDto.getProductQty())
                .productTotalPrice(productDto.getProductTotalPrice())
                .build();
    }

    private List<ProductDetails> mapProductAccessFromTransferList(List<ProductDto> productDtoList) {
        log.info("Mapping multiple products for the individual customer sent from DTO/users -> DAO");
        return productDtoList
                .stream()
                .map(this::mapProductAccessFromTransfer)
                .collect(Collectors.toList());
    }

    //Multiple Post Customer from DTO -> DAO
    public List<CustomerDetails> mapCustomerAccessFromTransferList(List<CustomerDto> customerDtoList) {
        log.info("Mapping Multiple Customers sent from DTO/users -> DAO");
        return customerDtoList.stream()
                .map(this::mapCustomerAccessFromTransfer)
                .collect(Collectors.toList());
    }


    //DTO <- DAO
    // POST Request
    public CustomerDto mapCustomerTransferFromAccess(CustomerDetails customerDetails) {
        log.info("Mapping Individual Customer from DAO/repository -> DTO");
        return CustomerDto.builder()
                .firstName(customerDetails.getFirstName())
                .lastName(customerDetails.getLastName())
                .mobileNumber(customerDetails.getMobileNumber())
                .emailId(customerDetails.getEmailId())
                .productDto(mapProductTransferFromAccessList(customerDetails.getProductDetails()))
                .build();
    }

    private ProductDto mapProductTransferFromAccess(ProductDetails productDetails) {
        log.info("Mapping Individual Product for the customers from DAO/repository -> DTO");
        return ProductDto.builder()
                .productName(productDetails.getProductName())
                .productId(productDetails.getProductId())
                .productQty(productDetails.getProductQty())
                .productTotalPrice(productDetails.getProductTotalPrice())
                .build();
    }

    private List<ProductDto> mapProductTransferFromAccessList(List<ProductDetails> productDetailsList) {
        log.info("Mapping multiple products for the individual customer DAO/repository -> DAO");
        return productDetailsList
                .stream()
                .map(this::mapProductTransferFromAccess)
                .collect(Collectors.toList());
    }

    //Multiple Get Customer from DAO -> DTO
    public List<CustomerDto> mapCustomerTransferFromAccessList(List<CustomerDetails> customerDetailsList) {
        log.info("Mapping Multiple Customers sent from DTO/users -> DAO");
        return customerDetailsList.stream()
                .map(this::mapCustomerTransferFromAccess)
                .collect(Collectors.toList());
    }




}
