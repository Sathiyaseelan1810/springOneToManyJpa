package com.mapping.onetomany.jpa.controller;

import com.mapping.onetomany.jpa.dto.CustomerDto;
import com.mapping.onetomany.jpa.service.CustomerAbst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/retail/retailwebapi/mapping")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerAbst customerAbst;

    @PostMapping(value = "/addCustomer")
    public ResponseEntity<?> addCustomer(@Validated @RequestBody  CustomerDto customerDto) {
       log.info("Post request started successfully!");
       this.customerAbst.postCustomer(customerDto);
       return new ResponseEntity<>(customerDto, HttpStatus.CREATED);
    }

    @PostMapping(value = "/addCustomers")
    public ResponseEntity<?> addCustomers(@Validated @RequestBody List<CustomerDto> customerDtoList) {
       log.info("Post request started successfully for multiple customers!");
       this.customerAbst.postMultipleCustomers(customerDtoList);
       return new ResponseEntity<>(customerDtoList, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getAllCustomers")
    @ResponseBody
    public ResponseEntity<?> getAllCustomers() {
        log.info("Get all customers from repository");
        return new ResponseEntity<>(this.customerAbst.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping(value = "/getCustomer/{id}")
    @ResponseBody
    public ResponseEntity<?> getCustomer(@PathVariable Integer id) {
        log.info("Get matched customer from repository");
        return new ResponseEntity<>(this.customerAbst.getMatchedCustomer(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer id) {
        log.info("Matched customer deleted successfully");
        this.customerAbst.deleteCustomer(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }

    @GetMapping(value = "/customResponse")
    @ResponseBody
    public ResponseEntity<?> getCustomizedResponseQuery() {
        log.info("Retrieving the matched response through join query successfully");
        return new ResponseEntity<>(this.customerAbst.getCustomizedDetails(), HttpStatus.OK);
    }



}
