package com.mapping.onetomany.jpa.service;

import com.mapping.onetomany.jpa.dto.CustomResponse;
import com.mapping.onetomany.jpa.dto.CustomerDto;

import java.util.List;

public interface CustomerAbst {

    void postCustomer (CustomerDto customerDto);
    void postMultipleCustomers(List<CustomerDto> customerDtoList);
    CustomerDto getMatchedCustomer (Integer id);
    List<CustomerDto> getAllCustomers();
    void deleteCustomer(Integer id);
    List<CustomResponse> getCustomizedDetails();




}
